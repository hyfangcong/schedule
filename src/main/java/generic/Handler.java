package generic;

public interface Handler<Response> {
    <Request> Response hand(Request request);
}
