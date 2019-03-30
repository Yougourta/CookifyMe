package fr.facebook.hackathon.cookifyme.api;

public class BarcodeLookupApi {
    private static BarcodeLookupApi api;

    public static BarcodeLookupApi getApi(){
        if (api==null)
            api = new BarcodeLookupApi();
        return api;
    }

    private BarcodeLookupApi() { }


}
