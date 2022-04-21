package sc.stqa.pft.litecart.models;

import java.io.File;
import java.util.Date;
import java.util.Objects;

public class ProductData {
    private String productName;
    private String code;
    private String category;
    private String sku;
    private String keywords;
    private String validFrom;
    private String validTo;
    private String regularPrice;
    private String campaignPrice;
    private String company;
    private String shortDescription;
    private String description;
    private File photo;

    public File getPhoto() {
        return photo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductData that = (ProductData) o;
        return Objects.equals(productName, that.productName) && Objects.equals(code, that.code) && Objects.equals(category, that.category) && Objects.equals(sku, that.sku) && Objects.equals(keywords, that.keywords) && Objects.equals(validFrom, that.validFrom) && Objects.equals(validTo, that.validTo) && Objects.equals(regularPrice, that.regularPrice) && Objects.equals(campaignPrice, that.campaignPrice) && Objects.equals(company, that.company) && Objects.equals(shortDescription, that.shortDescription) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, code, category, sku, keywords, validFrom, validTo, regularPrice, campaignPrice, company, shortDescription, description);
    }

    public ProductData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public ProductData withShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductData withDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ProductData withCode(String code) {
        this.code = code;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ProductData withCategory(String category) {
        this.category = category;
        return this;
    }

    public String getSku() {
        return sku;
    }

    public ProductData withSku(String sku) {
        this.sku = sku;
        return this;
    }

    public String getKeywords() {
        return keywords;
    }

    public ProductData withKeywords(String keywords) {
        this.keywords = keywords;
        return this;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public ProductData withValidFrom(String validFrom) {
        this.validFrom = validFrom;
        return this;
    }

    public String getValidTo() {
        return validTo;
    }

    public ProductData withValidTo(String validTo) {
        this.validTo = validTo;
        return this;
    }

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
    public String toString() {
        return "ProductData{" +
                ", productName='" + productName + '\'' +
                ", regularPrice='" + regularPrice + '\'' +
                ", campaignPrice='" + campaignPrice + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

}
