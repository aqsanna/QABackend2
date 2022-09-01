package Utile;

import com.google.gson.annotations.SerializedName;
import groovyjarjarantlr4.v4.runtime.atn.SemanticContext;

import java.util.ArrayList;

public class Order {
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
    public int orderItemsCount;
    @SerializedName("client_curbside_pickup_info")
    public Object clientCurbsidePickupInfo;
    @SerializedName("transactions")
    public ArrayList<Transaction> transactions;
    @SerializedName("delivery")
    public Delivery delivery;

    public String getId() {
        return id;
    }

    public Order withId(String id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Order withStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public Order withConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
        return this;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Order withCreationDate(String creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public Order withModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
        return this;
    }

    public Dropoff getDropoff() {
        return dropoff;
    }

    public Order withDropoff(Dropoff dropoff) {
        this.dropoff = dropoff;
        return this;
    }

    public Payment getPayment() {
        return payment;
    }

    public Order withPayment(Payment payment) {
        this.payment = payment;
        return this;
    }

    public String getType() {
        return type;
    }

    public Order withType(String type) {
        this.type = type;
        return this;
    }

    public String getDisplayType() {
        return displayType;
    }

    public Order withDisplayType(String displayType) {
        this.displayType = displayType;
        return this;
    }

    public String getDeliveryTariff() {
        return deliveryTariff;
    }

    public Order withDeliveryTariff(String deliveryTariff) {
        this.deliveryTariff = deliveryTariff;
        return this;
    }

    public boolean isHasInstorePreparedProducts() {
        return hasInstorePreparedProducts;
    }

    public Order withHasInstorePreparedProducts(boolean hasInstorePreparedProducts) {
        this.hasInstorePreparedProducts = hasInstorePreparedProducts;
        return this;
    }

    public int getOrderItemsCount() {
        return orderItemsCount;
    }

    public Order withOrderItemsCount(int orderItemsCount) {
        this.orderItemsCount = orderItemsCount;
        return this;
    }

    public Object getClientCurbsidePickupInfo() {
        return clientCurbsidePickupInfo;
    }

    public Order withClientCurbsidePickupInfo(Object clientCurbsidePickupInfo) {
        this.clientCurbsidePickupInfo = clientCurbsidePickupInfo;
        return this;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public Order withTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Order withDelivery(Delivery delivery) {
        this.delivery = delivery;
        return this;
    }

    public static class Transaction{
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

        public String getId() {
            return id;
        }

        public Transaction withId(String id) {
            this.id = id;
            return this;
        }

        public String getType() {
            return type;
        }

        public Transaction withType(String type) {
            this.type = type;
            return this;
        }

        public String getIcon() {
            return icon;
        }

        public Transaction withIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public Transaction withCardInfo(CardInfo cardInfo) {
            this.cardInfo = cardInfo;
            return this;
        }

        public ArrayList<String> getDescription() {
            return description;
        }

        public Transaction withDescription(ArrayList<String> description) {
            this.description = description;
            return this;
        }

        public String getAmount() {
            return amount;
        }

        public Transaction withAmount(String amount) {
            this.amount = amount;
            return this;
        }

        public boolean isRefundable() {
            return refundable;
        }

        public Transaction withRefundable(boolean refundable) {
            this.refundable = refundable;
            return this;
        }

        public String getTransactionID() {
            return transactionID;
        }

        public Transaction withTransactionID(String transactionID) {
            this.transactionID = transactionID;
            return this;
        }

        public ArrayList<Object> getRelatedTransactions() {
            return relatedTransactions;
        }

        public Transaction withRelatedTransactions(ArrayList<Object> relatedTransactions) {
            this.relatedTransactions = relatedTransactions;
            return this;
        }

        public String getRefundErrorMessage() {
            return refundErrorMessage;
        }

        public Transaction withRefundErrorMessage(String refundErrorMessage) {
            this.refundErrorMessage = refundErrorMessage;
            return this;
        }

        public class CardInfo{
            @SerializedName("cardType")
            public String cardType;
            @SerializedName("cardNumber")
            public String cardNumber;

            public String getCardType() {
                return cardType;
            }

            public CardInfo withCardType(String cardType) {
                this.cardType = cardType;
                return this;
            }

            public String getCardNumber() {
                return cardNumber;
            }

            public CardInfo withCardNumber(String cardNumber) {
                this.cardNumber = cardNumber;
                return this;
            }
        }

    }
    public static class Dropoff{
        @SerializedName("period")
        public Period period;
        @SerializedName("person")
        public Person person;

        public Period getPeriod() {
            return period;
        }

        public Dropoff withPeriod(Period period) {
            this.period = period;
            return this;
        }

        public Person getPerson() {
            return person;
        }

        public Dropoff withPerson(Person person) {
            this.person = person;
            return this;
        }
        public static class Person{
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

            public String getId() {
                return id;
            }

            public Person withId(String id) {
                this.id = id;
                return this;
            }

            public String getFirstName() {
                return firstName;
            }

            public Person withFirstName(String firstName) {
                this.firstName = firstName;
                return this;
            }

            public String getLastName() {
                return lastName;
            }

            public Person withLastName(String lastName) {
                this.lastName = lastName;
                return this;
            }

            public String getPhone() {
                return phone;
            }

            public Person withPhone(String phone) {
                this.phone = phone;
                return this;
            }

            public String getMembershipId() {
                return membershipId;
            }

            public Person withMembershipId(String membershipId) {
                this.membershipId = membershipId;
                return this;
            }
        }
        public static class Period{
            @SerializedName("start")
            public String start;
            @SerializedName("end")
            public String end;

            public String getStart() {
                return start;
            }

            public Period withStart(String start) {
                this.start = start;
                return this;
            }

            public String getEnd() {
                return end;
            }

            public Period withEnd(String end) {
                this.end = end;
                return this;
            }
        }
    }
    public static class Payment{
        @SerializedName("type")
        public ArrayList<String> type;
        @SerializedName("tip")
        public float tip;
        @SerializedName("total")
        public double total;
        @SerializedName("currency")
        public String currency;
        @SerializedName("currency_symbol")
        public String currencySymbol;
        @SerializedName("bag")
        public Bag bag;
        @SerializedName("additional_freeze_percent")
        public int additionalFreezePercent;
        @SerializedName("maximum_excess_amount_percent")
        public int maximumExcessAmountPercent;

        public ArrayList<String> getType() {
            return type;
        }

        public Payment withType(ArrayList<String> type) {
            this.type = type;
            return this;
        }

        public float getTip() {
            return tip;
        }

        public Payment withTip(int tip) {
            this.tip = tip;
            return this;
        }

        public double getTotal() {
            return total;
        }

        public Payment withTotal(double total) {
            this.total = total;
            return this;
        }

        public String getCurrency() {
            return currency;
        }

        public Payment withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public String getCurrencySymbol() {
            return currencySymbol;
        }

        public Payment withCurrencySymbol(String currencySymbol) {
            this.currencySymbol = currencySymbol;
            return this;
        }

        public Bag getBag() {
            return bag;
        }

        public Payment withBag(Bag bag) {
            this.bag = bag;
            return this;
        }

        public int getAdditionalFreezePercent() {
            return additionalFreezePercent;
        }

        public Payment withAdditionalFreezePercent(int additionalFreezePercent) {
            this.additionalFreezePercent = additionalFreezePercent;
            return this;
        }

        public int getMaximumExcessAmountPercent() {
            return maximumExcessAmountPercent;
        }

        public Payment withMaximumExcessAmountPercent(int maximumExcessAmountPercent) {
            this.maximumExcessAmountPercent = maximumExcessAmountPercent;
            return this;
        }
        public static class Bag{
            @SerializedName("qty")
            public int qty;

            public int getQty() {
                return qty;
            }

            public Bag withQty(int qty) {
                this.qty = qty;
                return this;
            }
        }
    }
    public static class Delivery{
        @SerializedName("driver")
        public String driver;
        @SerializedName("accepted_at")
        public String acceptedAt;
        @SerializedName("delivered_at")
        public String deliveredAt;

        public String getDriver() {
            return driver;
        }

        public Delivery withDriver(String driver) {
            this.driver = driver;
            return this;
        }

        public String getAcceptedAt() {
            return acceptedAt;
        }

        public Delivery withAcceptedAt(String acceptedAt) {
            this.acceptedAt = acceptedAt;
            return this;
        }

        public String getDeliveredAt() {
            return deliveredAt;
        }

        public Delivery withDeliveredAt(String deliveredAt) {
            this.deliveredAt = deliveredAt;
            return this;
        }
    }
}
