package run.calo.app;

public class getid {
    private final long id;
    private final String content;

    public getid(long id , String content){
        this.id = id;
        this.content = content;
    }

    public long getId(){
        return id;
    }
    public String getcontent(){
        return content;
    }

}
