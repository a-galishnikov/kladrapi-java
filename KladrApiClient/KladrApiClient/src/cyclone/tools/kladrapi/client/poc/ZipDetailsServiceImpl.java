package cyclone.tools.kladrapi.client.poc;

import cyclone.tools.kladrapi.client.KladrApiClient;
import cyclone.tools.kladrapi.client.KladrObject;

public class ZipDetailsServiceImpl implements ZipDetailsService{

    private KladrApiClient kladrApiClient;

    // Do dependency injection here
    public ZipDetailsServiceImpl(KladrApiClient kladrApiClient) {
        this.kladrApiClient = kladrApiClient;
    }

    @Override
    public ZipDetails resolveZip(String zipCode) {
        KladrObject kladrObject = kladrApiClient.getBuildingWithParentsByZipCode(zipCode);
        if (kladrObject == null) {
            // KladrApiClient uses bad error handling
            // It should be refactored for production usage
            // Leaving as is for POC
            return null;
        }
        String cityId = null, cityName = null, districtName = null, regionName = null;
        for (KladrObject parent : kladrObject.getParents()) {
            switch (parent.getContentType()) {
                case "region" : regionName = parent.getName(); break;
                case "district" : districtName = parent.getName(); break;
                case "city" : cityId = parent.getId(); cityName = parent.getName(); break;
                default: break;
            }
        }
        return new ZipDetails(cityId, cityName, districtName, regionName);
    }
}
