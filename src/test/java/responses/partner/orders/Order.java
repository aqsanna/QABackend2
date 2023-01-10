package responses.partner.orders;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Order {
    @SerializedName("data")
    public Data data;
    @SerializedName("code")
    private Integer code;
    @SerializedName("result")
    private String result;
    @SerializedName("error")
    private String error;

    @Getter
    public static class Data {
        @SerializedName("id")
        public String id;
        @SerializedName("status")
        public String status;
        @SerializedName("is_confirmed")
        public boolean isConfirmed;
        @SerializedName("creation_date")
        public String creationDate;
        @SerializedName("modification_date")
        public String modificationDate;
        @SerializedName("dropoff")
        public Dropoff dropoff;
        @SerializedName("payment")
        public Payment payment;
        @SerializedName("type")
        public String type;
        @SerializedName("display_type")
        public String displayType;
        @SerializedName("delivery_tariff")
        public String deliveryTariff;
        @SerializedName("has_instore_prepared_products")
        public boolean hasInstorePreparedProducts;
        @SerializedName("order_items_count")
        public Integer orderItemsCount;
        @SerializedName("client_curbside_pickup_info")
        public Object clientCurbsidePickupInfo;
        @SerializedName("isEbtPostpaid")
        public boolean isEbtPostpaid;
        @SerializedName("transactions")
        public ArrayList<Transaction> transactions;
        @SerializedName("delivery")
        public Delivery delivery;
        @SerializedName("wrapping")
        public Wrapping wrapping;
        @SerializedName("is_wl")
        public boolean isWl;
        @SerializedName("internal_notes")
        public String internalNotes;
        @SerializedName("time_left")
        public String timeLeft;
        @SerializedName("preparation_time")
        public int preparationTime;
        @SerializedName("grouped_items")
        public ArrayList<GroupedItem> groupedItems;
        @SerializedName("requires_id")
        public boolean requiresId;
        @SerializedName("initial_shipping_token")
        public Object initialShippingToken;

        public static class Dropoff {
            @SerializedName("period")
            public Period period;
            @SerializedName("person")
            public Person person;
            @SerializedName("address")
            public Address address;
            @SerializedName("instructions")
            public Object instructions;
            @SerializedName("notes")
            public Object notes;

            public static class Period {
                @SerializedName("start")
                public String start;
                @SerializedName("end")
                public String end;
            }

            public static class Person {
                @SerializedName("id")
                public String id;
                @SerializedName("first_name")
                public String firstName;
                @SerializedName("last_name")
                public String lastName;
                @SerializedName("phone")
                public String phone;
                @SerializedName("membership_id")
                public String membershipId;
            }

            public static class Address {
                @SerializedName("first_line")
                public String firstLine;
                @SerializedName("second_line")
                public Object secondLine;
                @SerializedName("location")
                public Location location;

                public static class Location {
                    @SerializedName("lat")
                    public String lat;
                    @SerializedName("lng")
                    public String lng;
                }
            }
        }

        public static class Payment {
            @SerializedName("type")
            public ArrayList<String> type;
            @SerializedName("tip")
            public Double tip;
            @SerializedName("total")
            public Double total;
            @SerializedName("currency")
            public String currency;
            @SerializedName("currency_symbol")
            public String currencySymbol;
            @SerializedName("bag")
            public Bag bag;
            @SerializedName("additional_freeze_percent")
            public Integer additionalFreezePercent;
            @SerializedName("maximum_excess_amount_percent")
            public Integer maximumExcessAmountPercent;
            @SerializedName("subtotal")
            public Double subtotal;
            @SerializedName("taxes")
            public ArrayList<Taxis> taxes;
            @SerializedName("fees")
            public ArrayList<Fee> fees;
            @SerializedName("coupon")
            public Object coupon;
            @SerializedName("original_total")
            public Double originalTotal;

            public static class Bag {
                @SerializedName("lng")
                public Integer qty;
                @SerializedName("price")
                public Integer price;
                @SerializedName("single_price")
                public Integer singlePrice;
                @SerializedName("free_qty")
                public Integer freeQty;
            }

            public static class Taxis {
                @SerializedName("title")
                public String title;
                @SerializedName("amount")
                public Double amount;
            }

            public static class Fee {
                @SerializedName("id")
                public String id;
                @SerializedName("title")
                public String title;
                @SerializedName("amount")
                public Double amount;
            }
        }

        public static class Transaction {
            @SerializedName("id")
            public String id;
            @SerializedName("type")
            public String type;
            @SerializedName("icon")
            public String icon;
            @SerializedName("cardInfo")
            public Object cardInfo;
            @SerializedName("description")
            public ArrayList<String> description;
            @SerializedName("amount")
            public String amount;
            @SerializedName("refundable")
            public boolean refundable;
            @SerializedName("transactionID")
            public String transactionID;
            @SerializedName("relatedTransactions")
            public ArrayList<Object> relatedTransactions;
            @SerializedName("refundErrorMessage")
            public String refundErrorMessage;
            @SerializedName("status")
            public String status;
            @SerializedName("isEbt")
            public boolean isEbt;
        }

        public static class Delivery {
            @SerializedName("driver")
            public Object driver;
            @SerializedName("accepted_at")
            public Object acceptedAt;
            @SerializedName("delivered_at")
            public Object deliveredAt;
        }

        @Getter
        public static class Wrapping {
            @SerializedName("packs")
            public ArrayList<Pack> packs;
            @SerializedName("hasAdvancedCollectingFlow")
            public boolean hasAdvancedCollectingFlow;
            @SerializedName("locations")
            public ArrayList<Object> locations;

            @Getter
            public static class Pack {
                @SerializedName("id")
                public String id;
                @SerializedName("pack_id")
                public String packId;
                @SerializedName("title")
                public String title;
                @SerializedName("type")
                public String type;
                @SerializedName("free_qty")
                public String freeQty;
                @SerializedName("qty")
                public String qty;
                @SerializedName("price")
                public String price;
                @SerializedName("upc")
                public String upc;
                @SerializedName("status")
                public String status;
                @SerializedName("total")
                public int total;
            }
        }

        @Getter
        public static class GroupedItem {
            @SerializedName("group")
            public Group group;
            @SerializedName("order_products")
            public ArrayList<OrderProduct> orderProducts;

            public static class Group {
                @SerializedName("id")
                public String id;
                @SerializedName("title")
                public String title;
            }

            @Getter
            public static class OrderProduct {
                @SerializedName("id")
                public String id;
                @SerializedName("product")
                public Product product;
                @SerializedName("replacement")
                public Replacement replacement;
                @SerializedName("status")
                public String status;
                @SerializedName("replaced_to")
                public Object replacedTo;
                @SerializedName("original_qty")
                public Double originalQty;
                @SerializedName("qty")
                public Float qty;
                @SerializedName("free_qty")
                public Double freeQty;
                @SerializedName("price")
                public String price;
                @SerializedName("final_price")
                public String finalPrice;
                @SerializedName("discount")
                public Discount discount;
                @SerializedName("notes")
                public String notes;
                @SerializedName("requested_items_quantity")
                public Integer requestedItemsQuantity;
                @SerializedName("box_id")
                public Object boxId;
                @SerializedName("in_stock")
                public Double inStock;

                public static class Product {
                    @SerializedName("id")
                    public String id;
                    @SerializedName("source")
                    public String source;
                    @SerializedName("upc")
                    public String upc;
                    @SerializedName("title")
                    public String title;
                    @SerializedName("image")
                    public Image image;
                    @SerializedName("price")
                    public String price;
                    @SerializedName("final_price")
                    public Double finalPrice;
                    @SerializedName("price_units")
                    public String priceUnits;
                    @SerializedName("is_instock")
                    public boolean isInstock;
                    @SerializedName("is_foodstamp")
                    public boolean isFoodstamp;
                    @SerializedName("has_modifications")
                    public boolean hasModifications;
                    @SerializedName("has_availability_schedule")
                    public boolean hasAvailabilitySchedule;
                    @SerializedName("display_volume")
                    public String displayVolume;
                    @SerializedName("store_id")
                    public String storeId;
                    @SerializedName("track_by_qty")
                    public boolean trackByQty;
                    @SerializedName("barcode")
                    public String barcode;
                    @SerializedName("description")
                    public String description;
                    @SerializedName("ingredients")
                    public String ingredients;
                    @SerializedName("nutrition_image")
                    public NutritionImage nutritionImage;
                    @SerializedName("additional_images")
                    public ArrayList<AdditionalImage> additionalImages;
                    @SerializedName("volume")
                    public String volume;
                    @SerializedName("volume_units")
                    public String volumeUnits;
                    @SerializedName("qty_in_pack")
                    public String qtyInPack;
                    @SerializedName("category")
                    public Category category;
                    @SerializedName("additional_categories")
                    public ArrayList<Object> additionalCategories;
                    @SerializedName("manufacturer")
                    public Manufacturer manufacturer;
                    @SerializedName("brand")
                    public Brand brand;
                    @SerializedName("tags")
                    public ArrayList<Tag> tags;
                    @SerializedName("pos")
                    public Pos pos;
                    @SerializedName("availability")
                    public ArrayList<Object> availability;
                    @SerializedName("tax")
                    public ArrayList<Tax> tax;
                    @SerializedName("discounts")
                    public ArrayList<Discount> discounts;
                    @SerializedName("settings")
                    public Settings settings;
                    @SerializedName("length")
                    public double length;
                    @SerializedName("width")
                    public double width;
                    @SerializedName("height")
                    public double height;
                    @SerializedName("weight")
                    public double weight;
                    @SerializedName("is_shippable")
                    public boolean isShippable;
                    @SerializedName("modification")
                    public Object modification;

                    public static class Image {
                        @SerializedName("original")
                        public String original;
                        @SerializedName("thumbnail")
                        public String thumbnail;
                        @SerializedName("large")
                        public String large;
                    }

                    public static class NutritionImage {
                        @SerializedName("original")
                        public String original;
                        @SerializedName("thumbnail")
                        public String thumbnail;
                        @SerializedName("large")
                        public String large;
                    }

                    public static class AdditionalImage {
                        @SerializedName("id")
                        public String id;
                        @SerializedName("original")
                        public String original;
                        @SerializedName("thumbnail")
                        public String thumbnail;
                        @SerializedName("large")
                        public String large;
                    }

                    public static class Category {
                        @SerializedName("id")
                        public String id;
                        @SerializedName("title")
                        public String title;
                        @SerializedName("department")
                        public Department department;

                        public static class Department {
                            @SerializedName("id")
                            public String id;
                            @SerializedName("title")
                            public String title;
                        }
                    }

                    public static class Manufacturer {
                        @SerializedName("id")
                        public String id;
                        @SerializedName("title")
                        public String title;
                    }

                    public static class Brand {
                        @SerializedName("id")
                        public String id;
                        @SerializedName("title")
                        public String title;
                    }

                    public static class Tag {
                        @SerializedName("id")
                        public String id;
                        @SerializedName("title")
                        public String title;
                    }

                    public static class Pos {
                        @SerializedName("id")
                        public Object id;
                        @SerializedName("exclude_from_pos_sync")
                        public boolean excludeFromPosSync;
                    }

                    public static class Tax {
                        @SerializedName("id")
                        public String id;
                        @SerializedName("title")
                        public String title;
                        @SerializedName("is_active")
                        public boolean isActive;
                        @SerializedName("apply_to_all_products")
                        public boolean applyToAllProducts;
                    }

                    public static class Discount {
                        @SerializedName("id")
                        public String id;
                        @SerializedName("title")
                        public String title;
                        @SerializedName("start_date")
                        public Object startDate;
                        @SerializedName("end_date")
                        public Object endDate;
                        @SerializedName("type")
                        public String type;
                        @SerializedName("description")
                        public String description;
                    }

                    public static class Settings {
                        @SerializedName("quantity")
                        public Quantity quantity;
                        @SerializedName("weight")
                        public Weight weight;

                        public static class Quantity {
                            @SerializedName("initial")
                            public Double initial;
                            @SerializedName("min")
                            public Double min;
                            @SerializedName("max")
                            public Double max;
                            @SerializedName("step")
                            public Double step;
                        }

                        public static class Weight {
                            @SerializedName("initial")
                            public Double initial;
                            @SerializedName("min")
                            public Double min;
                            @SerializedName("max")
                            public Double max;
                            @SerializedName("step")
                            public Double step;
                        }
                    }
                }

                public static class Replacement {
                    @SerializedName("type")
                    public String type;
                    @SerializedName("product")
                    public Object product;
                }

                public static class Discount {
                    @SerializedName("id")
                    public String id;
                    @SerializedName("title")
                    public String title;
                    @SerializedName("start_date")
                    public Object startDate;
                    @SerializedName("end_date")
                    public Object endDate;
                    @SerializedName("type")
                    public String type;
                    @SerializedName("description")
                    public String description;
                }
            }
        }
    }
}
