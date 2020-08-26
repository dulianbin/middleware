package com.dulianbin.demo.function.map;



import java.io.Serializable;
import java.util.Date;


public class OrderDetail implements Serializable {

    /**
     * 子单号id
     */
    private Long orderDetailId;

    /**
     * 订单号id
     */
    private Long orderId;

    /**
     * 商品编码
     */
    private Long itemId;

    /**
     * 接龙ID
     */
    private Long groupingId;

    /**
     * 商品单价
     */
    private Integer itemPrice;

    /**
     * 购买数量
     */
    private Integer buyCount;

    /**
     * 创建人Id
     */
    private Long createUser;

    /**
     * 更新者Id
     */
    private Long modifyUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date modifyTime;

    /**
     * 是否删除(0:未删除,1:已删除)
     */
    private Integer isDeleted;

    /**
     * 佣金点数
     */
    private Integer commissionPoint;

    private String itemName;

    private String itemImg;

    /**
     * 商品规格
     **/
    private String itemSpec;

    /**
     * 是否可以退货
     */
    private Integer canReturn;

    /***
     * 排期id
     */
    private Long planId = 0L;
    /**
     * return_status的描述改为跟售后单状态一致：售后单状态【-1默认值，0-待审核; 10-审核通过; 20-审核不通过;25货物寄回;27货物寄回审核不通过 30-团长已收货; 40-退款中;
     * 50-已退款 60-退款失败; 70-补偿优惠券 80-已取消】
     */
    private Integer returnStatus;

    /**
     * 当前商品摊分的优惠金额
     */
    private Integer couponValue;


    /**
     * 提货状态,0：未提货，1：已提货
     */
    private Integer pickStatus;

    /**
     * 确认提货时间
     */
    private Date pickTime;

    /**
     * 预售商品发货日期
     */
    private Date preTime;

    private Long categoryId;

    private Integer wholesaleSku;


    private Long promotionRuleId;

    private Integer promotionMoney;

    private Integer promotionNum;

    private Integer balancePayMoney;

    private Integer coinPay;

    private Integer actualPayMoney;

    private String subOrderId;

    /**
     * 预计送达时间
     */
    private Date arrivalsTime;
    /**
     * 已退金额
     */
    private Integer refundedAmount;
    private Integer isPreSell;
    private String outItemNo;

    /**
     * 商品类型 0 主品 1 买一赠一 2 赠品
     */
    private int itemType = 0;

    /**
     * 关联的主排期id 买一赠一、赠品、tu商品有值
     */
    private Long relationPlanId = 0L;

    /**
     * 关联的主商品id 买一赠一、赠品、tu商品有值
     */
    private Long mainItemId = 0L;

    /**
     * 是否新人价商品.0:否，1:是
     */
    private Integer isNewConsumerPriceItem;


    public int calcShouldPayMoney() {
        int itemCouponValue = couponValue == null ? 0 : couponValue;
        int itemPromotionMoney = promotionMoney == null ? 0 : promotionMoney;
        return itemPrice * buyCount - itemCouponValue - itemPromotionMoney;
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getGroupingId() {
        return groupingId;
    }

    public void setGroupingId(Long groupingId) {
        this.groupingId = groupingId;
    }

    public Integer getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getCommissionPoint() {
        return commissionPoint;
    }

    public void setCommissionPoint(Integer commissionPoint) {
        this.commissionPoint = commissionPoint;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemSpec() {
        return itemSpec;
    }

    public void setItemSpec(String itemSpec) {
        this.itemSpec = itemSpec;
    }

    public Integer getCanReturn() {
        return canReturn;
    }

    public void setCanReturn(Integer canReturn) {
        this.canReturn = canReturn;
    }

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Integer getReturnStatus() {
        return returnStatus;
    }

    public void setReturnStatus(Integer returnStatus) {
        this.returnStatus = returnStatus;
    }

    public Integer getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(Integer couponValue) {
        this.couponValue = couponValue;
    }

    public Integer getPickStatus() {
        return pickStatus;
    }

    public void setPickStatus(Integer pickStatus) {
        this.pickStatus = pickStatus;
    }

    public Date getPickTime() {
        return pickTime;
    }

    public void setPickTime(Date pickTime) {
        this.pickTime = pickTime;
    }

    public Date getPreTime() {
        return preTime;
    }

    public void setPreTime(Date preTime) {
        this.preTime = preTime;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getWholesaleSku() {
        return wholesaleSku;
    }

    public void setWholesaleSku(Integer wholesaleSku) {
        this.wholesaleSku = wholesaleSku;
    }

    public Long getPromotionRuleId() {
        return promotionRuleId;
    }

    public void setPromotionRuleId(Long promotionRuleId) {
        this.promotionRuleId = promotionRuleId;
    }

    public Integer getPromotionMoney() {
        return promotionMoney;
    }

    public void setPromotionMoney(Integer promotionMoney) {
        this.promotionMoney = promotionMoney;
    }

    public Integer getPromotionNum() {
        return promotionNum;
    }

    public void setPromotionNum(Integer promotionNum) {
        this.promotionNum = promotionNum;
    }

    public Integer getBalancePayMoney() {
        return balancePayMoney;
    }

    public void setBalancePayMoney(Integer balancePayMoney) {
        this.balancePayMoney = balancePayMoney;
    }

    public Integer getCoinPay() {
        return coinPay;
    }

    public void setCoinPay(Integer coinPay) {
        this.coinPay = coinPay;
    }

    public Integer getActualPayMoney() {
        return actualPayMoney;
    }

    public void setActualPayMoney(Integer actualPayMoney) {
        this.actualPayMoney = actualPayMoney;
    }

    public String getSubOrderId() {
        return subOrderId;
    }

    public void setSubOrderId(String subOrderId) {
        this.subOrderId = subOrderId;
    }

    public Date getArrivalsTime() {
        return arrivalsTime;
    }

    public void setArrivalsTime(Date arrivalsTime) {
        this.arrivalsTime = arrivalsTime;
    }

    public Integer getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(Integer refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public Integer getIsPreSell() {
        return isPreSell;
    }

    public void setIsPreSell(Integer isPreSell) {
        this.isPreSell = isPreSell;
    }

    public String getOutItemNo() {
        return outItemNo;
    }

    public void setOutItemNo(String outItemNo) {
        this.outItemNo = outItemNo;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public Long getRelationPlanId() {
        return relationPlanId;
    }

    public void setRelationPlanId(Long relationPlanId) {
        this.relationPlanId = relationPlanId;
    }

    public Long getMainItemId() {
        return mainItemId;
    }

    public void setMainItemId(Long mainItemId) {
        this.mainItemId = mainItemId;
    }

    public Integer getIsNewConsumerPriceItem() {
        return isNewConsumerPriceItem;
    }

    public void setIsNewConsumerPriceItem(Integer isNewConsumerPriceItem) {
        this.isNewConsumerPriceItem = isNewConsumerPriceItem;
    }
}
