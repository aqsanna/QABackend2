package storage;

public enum ExpandParams {
//    additionalFees,packs, curbsidePickupInfo, availablePreparationTimes, products, productsCount, wrapping, transactions, appliedTaxes, couponDeduction, productShippingPackagingBoxes, shippingTransactions, preSelectedShippingMessage, signaturePhoto, orderPhoto, idCardPhoto, isAgeVerificationRequired, isAgeVerified, excludeFromCollectingThrottling, shippingRate
    ADDITIONAL_FEES("additionalFees"),
    PACKS("packs"),
    CURBSIDE_PICKUP_INFO("curbsidePickupInfo"),
    AVAILABLE_PREPARATION_TIMES("availablePreparationTimes"),
    PRODUCTS("products"),
    PRODUCTS_COUNT("productsCount"),
    WRAPPING("wrapping"),
    TRANSACTIONS("transactions"),
    APPLIED_TAXES("appliedTaxes"),
    COUPON_DEDUCTION("couponDeduction"),
    PRODUCT_SHIPPING_PACKAGING_BOXES("productShippingPackagingBoxes"),
    SHIPPING_TRANSACTIONS("shippingTransactions"),
    PRE_SELECTED_SHIPPING_MESSAGE("preSelectedShippingMessage"),
    SIGNATURE_PHOTO("signaturePhoto"),
    ORDER_PHOTO("orderPhoto"),
    ID_CARD_PHOTO("idCardPhoto"),
    IS_AGE_VERIFICATION_REQUIRED("isAgeVerificationRequired"),
    IS_AGE_VERIFIED("isAgeVerified"),
    EXCLUDE_FROM_COLLECTING_THROTTLING("excludeFromCollectingThrottling"),
    SHIPPING_RATE("shippingRate");

    private final String expandParams;

    ExpandParams(String expandParams) {
        this.expandParams = expandParams;
    }

    public String getExpandParams() {
        return expandParams;
    }
}
