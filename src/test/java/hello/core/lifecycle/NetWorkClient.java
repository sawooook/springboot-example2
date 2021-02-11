package hello.core.lifecycle;

public class NetWorkClient {

    private String url;

    public NetWorkClient() {
        System.out.println("생성자 호출"+url);
        connect();
        call("초기화 연결 메시지");

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void connect() {
        System.out.println("connent"+url);
    }

    private void call(String message) {
        System.out.println("call:"+url+"messge: "+ message);
    }

    public void disconnect() {
        System.out.println("Close"+url);
    }
}
