package learnspring.springmybatis;

public class Master {
    private Long id;
    private Long slave_id;
    private Slave slave;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSlave_id() {
        return slave_id;
    }

    public void setSlave_id(Long slave_id) {
        this.slave_id = slave_id;
    }

    public Slave getSlave() {
        return slave;
    }

    public void setSlave(Slave slave) {
        this.slave = slave;
    }
}
