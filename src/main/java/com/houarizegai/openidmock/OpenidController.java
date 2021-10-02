package com.houarizegai.openidmock;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenidController {

    private static final String BASE_URL = "http://localhost:9999";
    private static final String EMAIL = "h.zegai@smartest.dz";

    @PostMapping(value = "/oauth/token", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getToken() {
        return "{\n" +
                "  \"access_token\": \"939a1dfc-cbb5-402a-a991-323339d59333\",\n" +
                "  \"token_type\": \"bearer\",\n" +
                "  \"refresh_token\": \"aad10a0b-a921-4da4-897e-db9d9837d582\",\n" +
                "  \"expires_in\": 9999999999999999,\n" +
                "  \"scope\": \"openid email\"\n" +
                "}";
    }

    @GetMapping(value = "/oauth/userinfo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUserInfo() {
        return "{\n" +
                "  \"sub\": \"00uid4BxXw6I6TV4m0g3\",\n" +
                "  \"name\" :\"John Doe\",\n" +
                "  \"nickname\":\"Jimmy\",\n" +
                "  \"given_name\":\"John\",\n" +
                "  \"middle_name\":\"James\",\n" +
                "  \"family_name\":\"Doe\",\n" +
                "  \"profile\":\"https://example.com/john.doe\",\n" +
                "  \"zoneinfo\":\"America/Los_Angeles\",\n" +
                "  \"locale\":\"en-US\",\n" +
                "  \"updated_at\":1311280970,\n" +
                "  \"email\":\"" + EMAIL + "\",\n" +
                "  \"email_verified\":true,\n" +
                "  \"phone_number\":\"+1 (425) 555-1212\"\n" +
                "}";
    }


    @GetMapping(value = "/.well-known/openid-configuration", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getConfig() {
        return "{\n" +
                "  \"issuer\":\"" + BASE_URL + "\",\n" +
                "  \"authorization_endpoint\":\"" + BASE_URL + "/oauth/auz/authorize\",\n" +
                "  \"token_endpoint\":\"" + BASE_URL + "/oauth/oauth/token\",\n" +
                "  \"userinfo_endpoint\":\"" + BASE_URL + "/oauth/userinfo\",\n" +
                "  \"jwks_uri\":\"" + BASE_URL + "/oauth/jwks\",\n" +
                "  \"scopes_supported\":[\n" +
                "    \"READ\",\n" +
                "    \"WRITE\",\n" +
                "    \"DELETE\",\n" +
                "    \"openid\",\n" +
                "    \"scope\",\n" +
                "    \"profile\",\n" +
                "    \"email\",\n" +
                "    \"address\",\n" +
                "    \"phone\"\n" +
                "  ],\n" +
                "  \"response_types_supported\":[\n" +
                "    \"code\",\n" +
                "    \"code id_token\",\n" +
                "    \"code token\",\n" +
                "    \"code id_token token\",\n" +
                "    \"token\",\n" +
                "    \"id_token\",\n" +
                "    \"id_token token\"\n" +
                "  ],\n" +
                "  \"grant_types_supported\":[\n" +
                "    \"authorization_code\",\n" +
                "    \"implicit\",\n" +
                "    \"password\",\n" +
                "    \"client_credentials\",\n" +
                "    \"urn:ietf:params:oauth:grant-type:jwt-bearer\"\n" +
                "  ],\n" +
                "  \"subject_types_supported\":[\n" +
                "    \"public\"\n" +
                "  ],\n" +
                "  \"id_token_signing_alg_values_supported\":[\n" +
                "    \"HS256\",\n" +
                "    \"HS384\",\n" +
                "    \"HS512\",\n" +
                "    \"RS256\",\n" +
                "    \"RS384\",\n" +
                "    \"RS512\",\n" +
                "    \"ES256\",\n" +
                "    \"ES384\",\n" +
                "    \"ES512\",\n" +
                "    \"PS256\",\n" +
                "    \"PS384\",\n" +
                "    \"PS512\"\n" +
                "  ],\n" +
                "  \"id_token_encryption_alg_values_supported\":[\n" +
                "    \"RSA1_5\",\n" +
                "    \"RSA-OAEP\",\n" +
                "    \"RSA-OAEP-256\",\n" +
                "    \"A128KW\",\n" +
                "    \"A192KW\",\n" +
                "    \"A256KW\",\n" +
                "    \"A128GCMKW\",\n" +
                "    \"A192GCMKW\",\n" +
                "    \"A256GCMKW\",\n" +
                "    \"dir\"\n" +
                "  ],\n" +
                "  \"id_token_encryption_enc_values_supported\":[\n" +
                "    \"A128CBC-HS256\",\n" +
                "    \"A192CBC-HS384\",\n" +
                "    \"A256CBC-HS512\",\n" +
                "    \"A128GCM\",\n" +
                "    \"A192GCM\",\n" +
                "    \"A256GCM\"\n" +
                "  ],\n" +
                "  \"token_endpoint_auth_methods_supported\":[\n" +
                "    \"client_secret_post\",\n" +
                "    \"client_secret_basic\",\n" +
                "    \"client_secret_jwt\",\n" +
                "    \"private_key_jwt\"\n" +
                "  ],\n" +
                "  \"token_endpoint_auth_signing_alg_values_supported\":[\n" +
                "    \"HS256\",\n" +
                "    \"RS256\"\n" +
                "  ],\n" +
                "  \"claims_parameter_supported\":false,\n" +
                "  \"request_parameter_supported\":false,\n" +
                "  \"request_uri_parameter_supported\":false\n" +
                "}";
    }



    @GetMapping(value = "/oauth/jwks", produces = MediaType.APPLICATION_JSON_VALUE)
    public String jwks() {
        return "{\n" +
                "  \"keys\" : [ {\n" +
                "    \"kty\" : \"RSA\",\n" +
                "    \"kid\" : \"1438289820780\",\n" +
                "    \"use\" : \"sig\",\n" +
                "    \"alg\" : \"RS256\",\n" +
                "    \"n\" : \"idWPro_QiAFOdMsJD163lcDIPogOwXogRo3Pct2MMyeE2GAGqV20Sc8QUbuLDfPl-7Hi9IfFOz--JY6QL5l92eV-GJXkTmidUEooZxIZSp3ghRxLCqlyHeF5LuuM5LPRFDeF4YWFQT_D2eNo_w95g6qYSeOwOwGIfaHa2RMPcQAiM6LX4ot-Z7Po9z0_3ztFa02m3xejEFr2rLRqhFl3FZJaNnwTUk6an6XYsunxMk3Ya3lRaKJReeXeFtfTpShgtPiAl7lIfLJH9h26h2OAlww531DpxHSm1gKXn6bjB0NTC55vJKft4wXoc_0xKZhnWmjQE8d9xE8e1Z3Ll1LYbw\",\n" +
                "    \"e\" : \"AQAB\"\n" +
                "  }, {\n" +
                "    \"kty\" : \"RSA\",\n" +
                "    \"kid\" : \"1438289856256\",\n" +
                "    \"use\" : \"sig\",\n" +
                "    \"alg\" : \"RS256\",\n" +
                "    \"n\" : \"zo5cKcbFECeiH8eGx2D-DsFSpjSKbTVlXD6uL5JAy9rYIv7eYEP6vrKeX-x1z70yEdvgk9xbf9alc8siDfAz3rLCknqlqL7XGVAQL0ZP63UceDmD60LHOzMrx4eR6p49B3rxFfjvX2SWSV3-1H6XNyLk_ALbG6bGCFGuWBQzPJB4LMKCrOFq-6jtRKOKWBXYgkYkaYs5dG-3e2ULbq-y2RdgxYh464y_-MuxDQfvUgP787XKfcXP_XjJZvyuOEANjVyJYZSOyhHUlSGJapQ8ztHdF-swsnf7YkePJ2eR9fynWV2ZoMaXOdidgZtGTa4R1Z4BgH2C0hKJiqRy9fB7Gw\",\n" +
                "    \"e\" : \"AQAB\"\n" +
                "  } ]\n" +
                "}";
    }

}
