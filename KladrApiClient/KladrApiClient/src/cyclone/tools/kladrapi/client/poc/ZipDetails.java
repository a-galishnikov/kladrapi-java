package cyclone.tools.kladrapi.client.poc;

public class ZipDetails {
    private String cityId;
    private String cityName;
    private String districtName;
    private String regionName;

    public ZipDetails(String cityId, String cityName, String districtName, String regionName) {
        this.cityId = cityId;
        this.cityName = cityName;
        this.districtName = districtName;
        this.regionName = regionName;
    }

    public String getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getRegionName() {
        return regionName;
    }

    @Override
    public String toString() {
        return "ZipDetails{" +
                "cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", districtName='" + districtName + '\'' +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
