package learnspring.myblog.controllers;

import learnspring.myblog.dao.PostDAO;
import learnspring.myblog.dao.UserDAO;
import learnspring.myblog.dbitems.Category;
import learnspring.myblog.dbitems.Post;
import learnspring.myblog.extra.Glob;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleHtmlReportConfiguration;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.sql.Connection;

import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

@Controller
public class PostController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(PostController.class);

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/")
    public String index(@RequestParam(value="p", required=false, defaultValue="0") int p,
                        Model model){

        List<Post> posts = postDAO.getAll(p, Glob.postPerPage);

        model.addAttribute("p", p );
        model.addAttribute("posts", posts );
        model.addAttribute("content", "index");

        return "main";
    }

    @GetMapping("/post/{post_id}")
    public String post(
            @PathVariable int post_id,
            Model model) {

        Post post = postDAO.findById(post_id);

        model.addAttribute("post", post );
        model.addAttribute("content", "post");

        return "main";
    }

    @GetMapping("/post/{post_id}/pdf")
    public String postPdf(
            @PathVariable int post_id,
            Model model, HttpServletRequest request,HttpServletResponse response) throws ParseException {

        Post post = postDAO.findById(post_id);
        HashMap<String,Object> hmParams=new HashMap<String,Object>();
        hmParams.put("TITLE", new String(post.getTitle()));
        hmParams.put("BODY", new String(post.getBody()));
        hmParams.put("CREATED", new String(post.getCreated().toString()));

        try {

            JasperReport jasperReport = getCompiledFile("jr", request);
            generateReportPDF(response, hmParams, jasperReport, null);

        } catch (Exception sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        }

        return null;
    }

    private JasperReport getCompiledFile(String fileName, HttpServletRequest request) throws JRException {

        File reportFile = new File( request.getSession().getServletContext().getRealPath(fileName + ".jasper"));

        if (!reportFile.exists()) {
            JasperCompileManager.compileReportToFile(
                    request.getSession().getServletContext().getRealPath(fileName + ".jrxml"),
                    request.getSession().getServletContext().getRealPath(fileName + ".jasper")
            );
        }
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportFile.getPath());
        return jasperReport;
    }

    private void generateReportPDF (HttpServletResponse resp, Map parameters, JasperReport jasperReport, Connection conn)throws JRException, NamingException, SQLException, IOException {
        byte[] bytes = null;
        bytes = JasperRunManager.runReportToPdf(jasperReport,parameters);
        resp.reset();
        resp.resetBuffer();
        resp.setContentType("application/pdf");
        resp.setContentLength(bytes.length);
        ServletOutputStream ouputStream = resp.getOutputStream();
        ouputStream.write(bytes, 0, bytes.length);
        ouputStream.flush();
        ouputStream.close();
    }

    @GetMapping("/post/add/form")
    public String postAddForm(Model model){
        List<Category> categories = categoryDAO.getAll(0, Integer.MAX_VALUE);

        model.addAttribute("categories", categories);
        model.addAttribute("content", "postAddForm");

        return "main";
    }

    @PostMapping("/post/add")
    public String postAdd(@ModelAttribute("Post") Post post,
                          BindingResult result, ModelMap model){

        String error = "";
        if (post.getTitle().isEmpty() || post.getTitle().length() < 5) {
            error = "Title must be greater 5 symbols";
        }
        if (post.getBody().isEmpty() || post.getBody().length() < 50) {
            error = "Too short text";
        }

        if (!error.isEmpty()) {
            List<Category> categories = categoryDAO.getAll(0, Integer.MAX_VALUE);
            model.addAttribute("error", error);
            model.addAttribute("post", post);
            model.addAttribute("categories", categories);
            model.addAttribute("content", "postAddForm");
            return "main";
        }

        post.setUser_id(2L);
        post.setCreated(new Date());
        post = postDAO.save(post);

        return "redirect:/post/" + post.getId();
    }



}