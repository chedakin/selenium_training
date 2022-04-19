package sc.stqa.pft.litecart.models;

import java.util.Objects;

public class ProductData {
    private String productName;
    private String regularPrice;
    private String campaignPrice;
    private String company;

    public String getProductName() {
        return productName;
    }

    public ProductData withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getRegularPrice() {
        return regularPrice;
    }

    public ProductData withRegularPrice(String regularPrice) {
        this.regularPrice = regularPrice;
        return this;
    }

    public String getCampaignPrice() {
        return campaignPrice;
    }

    public ProductData withCampaignPrice(String salePrice) {
        this.campaignPrice = salePrice;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public ProductData withCompany(String company) {
        this.company = company;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductData that = (ProductData) o;
        return Objects.equals(productName, that.productName) && Objects.equals(regularPrice, that.regularPrice) && Objects.equals(campaignPrice, that.campaignPrice) && Objects.equals(company, that.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, regularPrice, campaignPrice, company);
    }

    @Override
    public String toString() {
        return "ProductData{" +
                ", productName='" + productName + '\'' +
                ", regularPrice='" + regularPrice + '\'' +
                ", campaignPrice='" + campaignPrice + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

}
