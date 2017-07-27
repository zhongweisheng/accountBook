package lb.rest.user.db.entity;

import fc.wpf.rest.utils.CustomDateSerializer;
import fc.wpf.rest.web.bean.Tab;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@Tab(name="mlbuser_addition")
public class MlbuserAddition extends MlbuserAdditionKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.user_category
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer userCategory;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.has_invoice
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer hasInvoice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.has_warehouse
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer hasWarehouse;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.company_name
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String companyName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.legal_person
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String legalPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.warename
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String warename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.wareaddress
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String wareaddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.warelocation
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer warelocation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.warelocationDesc
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String warelocationdesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.operate_year_limit
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer operateYearLimit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.month_turnover
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer monthTurnover;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.sale_area
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String saleArea;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.has_tower
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer hasTower;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.pay_on_delivery
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer payOnDelivery;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.grain_type
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer grainType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.buy_address
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String buyAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.monthly_require
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer monthlyRequire;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.industry
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer industry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.account_period
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer accountPeriod;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.bank_name
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String bankName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.bank_user_name
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String bankUserName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.bank_account_number
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String bankAccountNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.membership_group
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String membershipGroup;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.main_usage
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String mainUsage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.payment_flow
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String paymentFlow;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.quotation_mode
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer quotationMode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.company_location
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private Integer companyLocation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.company_locationDesc
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String companyLocationdesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column mlbuser_addition.company_address
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    private String companyAddress;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.user_category
     *
     * @return the value of mlbuser_addition.user_category
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getUserCategory() {
        return userCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.user_category
     *
     * @param userCategory the value for mlbuser_addition.user_category
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setUserCategory(Integer userCategory) {
        this.userCategory = userCategory;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.has_invoice
     *
     * @return the value of mlbuser_addition.has_invoice
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getHasInvoice() {
        return hasInvoice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.has_invoice
     *
     * @param hasInvoice the value for mlbuser_addition.has_invoice
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setHasInvoice(Integer hasInvoice) {
        this.hasInvoice = hasInvoice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.has_warehouse
     *
     * @return the value of mlbuser_addition.has_warehouse
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getHasWarehouse() {
        return hasWarehouse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.has_warehouse
     *
     * @param hasWarehouse the value for mlbuser_addition.has_warehouse
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setHasWarehouse(Integer hasWarehouse) {
        this.hasWarehouse = hasWarehouse;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.company_name
     *
     * @return the value of mlbuser_addition.company_name
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.company_name
     *
     * @param companyName the value for mlbuser_addition.company_name
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.legal_person
     *
     * @return the value of mlbuser_addition.legal_person
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.legal_person
     *
     * @param legalPerson the value for mlbuser_addition.legal_person
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.warename
     *
     * @return the value of mlbuser_addition.warename
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getWarename() {
        return warename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.warename
     *
     * @param warename the value for mlbuser_addition.warename
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setWarename(String warename) {
        this.warename = warename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.wareaddress
     *
     * @return the value of mlbuser_addition.wareaddress
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getWareaddress() {
        return wareaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.wareaddress
     *
     * @param wareaddress the value for mlbuser_addition.wareaddress
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setWareaddress(String wareaddress) {
        this.wareaddress = wareaddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.warelocation
     *
     * @return the value of mlbuser_addition.warelocation
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getWarelocation() {
        return warelocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.warelocation
     *
     * @param warelocation the value for mlbuser_addition.warelocation
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setWarelocation(Integer warelocation) {
        this.warelocation = warelocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.warelocationDesc
     *
     * @return the value of mlbuser_addition.warelocationDesc
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getWarelocationdesc() {
        return warelocationdesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.warelocationDesc
     *
     * @param warelocationdesc the value for mlbuser_addition.warelocationDesc
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setWarelocationdesc(String warelocationdesc) {
        this.warelocationdesc = warelocationdesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.operate_year_limit
     *
     * @return the value of mlbuser_addition.operate_year_limit
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getOperateYearLimit() {
        return operateYearLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.operate_year_limit
     *
     * @param operateYearLimit the value for mlbuser_addition.operate_year_limit
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setOperateYearLimit(Integer operateYearLimit) {
        this.operateYearLimit = operateYearLimit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.month_turnover
     *
     * @return the value of mlbuser_addition.month_turnover
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getMonthTurnover() {
        return monthTurnover;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.month_turnover
     *
     * @param monthTurnover the value for mlbuser_addition.month_turnover
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setMonthTurnover(Integer monthTurnover) {
        this.monthTurnover = monthTurnover;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.sale_area
     *
     * @return the value of mlbuser_addition.sale_area
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getSaleArea() {
        return saleArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.sale_area
     *
     * @param saleArea the value for mlbuser_addition.sale_area
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setSaleArea(String saleArea) {
        this.saleArea = saleArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.has_tower
     *
     * @return the value of mlbuser_addition.has_tower
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getHasTower() {
        return hasTower;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.has_tower
     *
     * @param hasTower the value for mlbuser_addition.has_tower
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setHasTower(Integer hasTower) {
        this.hasTower = hasTower;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.pay_on_delivery
     *
     * @return the value of mlbuser_addition.pay_on_delivery
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getPayOnDelivery() {
        return payOnDelivery;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.pay_on_delivery
     *
     * @param payOnDelivery the value for mlbuser_addition.pay_on_delivery
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setPayOnDelivery(Integer payOnDelivery) {
        this.payOnDelivery = payOnDelivery;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.grain_type
     *
     * @return the value of mlbuser_addition.grain_type
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getGrainType() {
        return grainType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.grain_type
     *
     * @param grainType the value for mlbuser_addition.grain_type
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setGrainType(Integer grainType) {
        this.grainType = grainType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.buy_address
     *
     * @return the value of mlbuser_addition.buy_address
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getBuyAddress() {
        return buyAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.buy_address
     *
     * @param buyAddress the value for mlbuser_addition.buy_address
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setBuyAddress(String buyAddress) {
        this.buyAddress = buyAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.monthly_require
     *
     * @return the value of mlbuser_addition.monthly_require
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getMonthlyRequire() {
        return monthlyRequire;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.monthly_require
     *
     * @param monthlyRequire the value for mlbuser_addition.monthly_require
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setMonthlyRequire(Integer monthlyRequire) {
        this.monthlyRequire = monthlyRequire;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.industry
     *
     * @return the value of mlbuser_addition.industry
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getIndustry() {
        return industry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.industry
     *
     * @param industry the value for mlbuser_addition.industry
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.account_period
     *
     * @return the value of mlbuser_addition.account_period
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getAccountPeriod() {
        return accountPeriod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.account_period
     *
     * @param accountPeriod the value for mlbuser_addition.account_period
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setAccountPeriod(Integer accountPeriod) {
        this.accountPeriod = accountPeriod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.bank_name
     *
     * @return the value of mlbuser_addition.bank_name
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.bank_name
     *
     * @param bankName the value for mlbuser_addition.bank_name
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.bank_user_name
     *
     * @return the value of mlbuser_addition.bank_user_name
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getBankUserName() {
        return bankUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.bank_user_name
     *
     * @param bankUserName the value for mlbuser_addition.bank_user_name
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setBankUserName(String bankUserName) {
        this.bankUserName = bankUserName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.bank_account_number
     *
     * @return the value of mlbuser_addition.bank_account_number
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.bank_account_number
     *
     * @param bankAccountNumber the value for mlbuser_addition.bank_account_number
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.membership_group
     *
     * @return the value of mlbuser_addition.membership_group
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getMembershipGroup() {
        return membershipGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.membership_group
     *
     * @param membershipGroup the value for mlbuser_addition.membership_group
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setMembershipGroup(String membershipGroup) {
        this.membershipGroup = membershipGroup;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.main_usage
     *
     * @return the value of mlbuser_addition.main_usage
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getMainUsage() {
        return mainUsage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.main_usage
     *
     * @param mainUsage the value for mlbuser_addition.main_usage
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setMainUsage(String mainUsage) {
        this.mainUsage = mainUsage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.payment_flow
     *
     * @return the value of mlbuser_addition.payment_flow
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getPaymentFlow() {
        return paymentFlow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.payment_flow
     *
     * @param paymentFlow the value for mlbuser_addition.payment_flow
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setPaymentFlow(String paymentFlow) {
        this.paymentFlow = paymentFlow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.quotation_mode
     *
     * @return the value of mlbuser_addition.quotation_mode
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getQuotationMode() {
        return quotationMode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.quotation_mode
     *
     * @param quotationMode the value for mlbuser_addition.quotation_mode
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setQuotationMode(Integer quotationMode) {
        this.quotationMode = quotationMode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.company_location
     *
     * @return the value of mlbuser_addition.company_location
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public Integer getCompanyLocation() {
        return companyLocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.company_location
     *
     * @param companyLocation the value for mlbuser_addition.company_location
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setCompanyLocation(Integer companyLocation) {
        this.companyLocation = companyLocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.company_locationDesc
     *
     * @return the value of mlbuser_addition.company_locationDesc
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getCompanyLocationdesc() {
        return companyLocationdesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.company_locationDesc
     *
     * @param companyLocationdesc the value for mlbuser_addition.company_locationDesc
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setCompanyLocationdesc(String companyLocationdesc) {
        this.companyLocationdesc = companyLocationdesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column mlbuser_addition.company_address
     *
     * @return the value of mlbuser_addition.company_address
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column mlbuser_addition.company_address
     *
     * @param companyAddress the value for mlbuser_addition.company_address
     *
     * @mbggenerated Sat Feb 25 19:11:44 CST 2017
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_addition
     *
     * @mbggenerated Sat Feb 25 19:11:45 CST 2017
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        MlbuserAddition other = (MlbuserAddition) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserCategory() == null ? other.getUserCategory() == null : this.getUserCategory().equals(other.getUserCategory()))
            && (this.getHasInvoice() == null ? other.getHasInvoice() == null : this.getHasInvoice().equals(other.getHasInvoice()))
            && (this.getHasWarehouse() == null ? other.getHasWarehouse() == null : this.getHasWarehouse().equals(other.getHasWarehouse()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getLegalPerson() == null ? other.getLegalPerson() == null : this.getLegalPerson().equals(other.getLegalPerson()))
            && (this.getWarename() == null ? other.getWarename() == null : this.getWarename().equals(other.getWarename()))
            && (this.getWareaddress() == null ? other.getWareaddress() == null : this.getWareaddress().equals(other.getWareaddress()))
            && (this.getWarelocation() == null ? other.getWarelocation() == null : this.getWarelocation().equals(other.getWarelocation()))
            && (this.getWarelocationdesc() == null ? other.getWarelocationdesc() == null : this.getWarelocationdesc().equals(other.getWarelocationdesc()))
            && (this.getOperateYearLimit() == null ? other.getOperateYearLimit() == null : this.getOperateYearLimit().equals(other.getOperateYearLimit()))
            && (this.getMonthTurnover() == null ? other.getMonthTurnover() == null : this.getMonthTurnover().equals(other.getMonthTurnover()))
            && (this.getSaleArea() == null ? other.getSaleArea() == null : this.getSaleArea().equals(other.getSaleArea()))
            && (this.getHasTower() == null ? other.getHasTower() == null : this.getHasTower().equals(other.getHasTower()))
            && (this.getPayOnDelivery() == null ? other.getPayOnDelivery() == null : this.getPayOnDelivery().equals(other.getPayOnDelivery()))
            && (this.getGrainType() == null ? other.getGrainType() == null : this.getGrainType().equals(other.getGrainType()))
            && (this.getBuyAddress() == null ? other.getBuyAddress() == null : this.getBuyAddress().equals(other.getBuyAddress()))
            && (this.getMonthlyRequire() == null ? other.getMonthlyRequire() == null : this.getMonthlyRequire().equals(other.getMonthlyRequire()))
            && (this.getIndustry() == null ? other.getIndustry() == null : this.getIndustry().equals(other.getIndustry()))
            && (this.getAccountPeriod() == null ? other.getAccountPeriod() == null : this.getAccountPeriod().equals(other.getAccountPeriod()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getBankUserName() == null ? other.getBankUserName() == null : this.getBankUserName().equals(other.getBankUserName()))
            && (this.getBankAccountNumber() == null ? other.getBankAccountNumber() == null : this.getBankAccountNumber().equals(other.getBankAccountNumber()))
            && (this.getMembershipGroup() == null ? other.getMembershipGroup() == null : this.getMembershipGroup().equals(other.getMembershipGroup()))
            && (this.getMainUsage() == null ? other.getMainUsage() == null : this.getMainUsage().equals(other.getMainUsage()))
            && (this.getPaymentFlow() == null ? other.getPaymentFlow() == null : this.getPaymentFlow().equals(other.getPaymentFlow()))
            && (this.getQuotationMode() == null ? other.getQuotationMode() == null : this.getQuotationMode().equals(other.getQuotationMode()))
            && (this.getCompanyLocation() == null ? other.getCompanyLocation() == null : this.getCompanyLocation().equals(other.getCompanyLocation()))
            && (this.getCompanyLocationdesc() == null ? other.getCompanyLocationdesc() == null : this.getCompanyLocationdesc().equals(other.getCompanyLocationdesc()))
            && (this.getCompanyAddress() == null ? other.getCompanyAddress() == null : this.getCompanyAddress().equals(other.getCompanyAddress()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_addition
     *
     * @mbggenerated Sat Feb 25 19:11:45 CST 2017
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserCategory() == null) ? 0 : getUserCategory().hashCode());
        result = prime * result + ((getHasInvoice() == null) ? 0 : getHasInvoice().hashCode());
        result = prime * result + ((getHasWarehouse() == null) ? 0 : getHasWarehouse().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getLegalPerson() == null) ? 0 : getLegalPerson().hashCode());
        result = prime * result + ((getWarename() == null) ? 0 : getWarename().hashCode());
        result = prime * result + ((getWareaddress() == null) ? 0 : getWareaddress().hashCode());
        result = prime * result + ((getWarelocation() == null) ? 0 : getWarelocation().hashCode());
        result = prime * result + ((getWarelocationdesc() == null) ? 0 : getWarelocationdesc().hashCode());
        result = prime * result + ((getOperateYearLimit() == null) ? 0 : getOperateYearLimit().hashCode());
        result = prime * result + ((getMonthTurnover() == null) ? 0 : getMonthTurnover().hashCode());
        result = prime * result + ((getSaleArea() == null) ? 0 : getSaleArea().hashCode());
        result = prime * result + ((getHasTower() == null) ? 0 : getHasTower().hashCode());
        result = prime * result + ((getPayOnDelivery() == null) ? 0 : getPayOnDelivery().hashCode());
        result = prime * result + ((getGrainType() == null) ? 0 : getGrainType().hashCode());
        result = prime * result + ((getBuyAddress() == null) ? 0 : getBuyAddress().hashCode());
        result = prime * result + ((getMonthlyRequire() == null) ? 0 : getMonthlyRequire().hashCode());
        result = prime * result + ((getIndustry() == null) ? 0 : getIndustry().hashCode());
        result = prime * result + ((getAccountPeriod() == null) ? 0 : getAccountPeriod().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getBankUserName() == null) ? 0 : getBankUserName().hashCode());
        result = prime * result + ((getBankAccountNumber() == null) ? 0 : getBankAccountNumber().hashCode());
        result = prime * result + ((getMembershipGroup() == null) ? 0 : getMembershipGroup().hashCode());
        result = prime * result + ((getMainUsage() == null) ? 0 : getMainUsage().hashCode());
        result = prime * result + ((getPaymentFlow() == null) ? 0 : getPaymentFlow().hashCode());
        result = prime * result + ((getQuotationMode() == null) ? 0 : getQuotationMode().hashCode());
        result = prime * result + ((getCompanyLocation() == null) ? 0 : getCompanyLocation().hashCode());
        result = prime * result + ((getCompanyLocationdesc() == null) ? 0 : getCompanyLocationdesc().hashCode());
        result = prime * result + ((getCompanyAddress() == null) ? 0 : getCompanyAddress().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mlbuser_addition
     *
     * @mbggenerated Sat Feb 25 19:11:45 CST 2017
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userCategory=").append(userCategory);
        sb.append(", hasInvoice=").append(hasInvoice);
        sb.append(", hasWarehouse=").append(hasWarehouse);
        sb.append(", companyName=").append(companyName);
        sb.append(", legalPerson=").append(legalPerson);
        sb.append(", warename=").append(warename);
        sb.append(", wareaddress=").append(wareaddress);
        sb.append(", warelocation=").append(warelocation);
        sb.append(", warelocationdesc=").append(warelocationdesc);
        sb.append(", operateYearLimit=").append(operateYearLimit);
        sb.append(", monthTurnover=").append(monthTurnover);
        sb.append(", saleArea=").append(saleArea);
        sb.append(", hasTower=").append(hasTower);
        sb.append(", payOnDelivery=").append(payOnDelivery);
        sb.append(", grainType=").append(grainType);
        sb.append(", buyAddress=").append(buyAddress);
        sb.append(", monthlyRequire=").append(monthlyRequire);
        sb.append(", industry=").append(industry);
        sb.append(", accountPeriod=").append(accountPeriod);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankUserName=").append(bankUserName);
        sb.append(", bankAccountNumber=").append(bankAccountNumber);
        sb.append(", membershipGroup=").append(membershipGroup);
        sb.append(", mainUsage=").append(mainUsage);
        sb.append(", paymentFlow=").append(paymentFlow);
        sb.append(", quotationMode=").append(quotationMode);
        sb.append(", companyLocation=").append(companyLocation);
        sb.append(", companyLocationdesc=").append(companyLocationdesc);
        sb.append(", companyAddress=").append(companyAddress);
        sb.append("]");
        return sb.toString();
    }
}