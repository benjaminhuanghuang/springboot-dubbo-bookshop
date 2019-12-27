package ben.study.web.support;

import com.github.tomakehurst.wiremock.client.WireMock;
import org.apache.http.impl.conn.Wire;


public class MockService {
    public static void main(String[] args) {
        WireMock.configureFor("127.0.0.1", 8080);

        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/book")).willReturn(WireMock.okJson("" +
                "{'name':'tom'}")));
    }
}
