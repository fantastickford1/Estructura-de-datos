public class Customers implements Comparable<Customers> {

  public String CustomerID;
  public String CompanyName;
  public String ContactName;
  public String ContactTitle;
  public String Address;
  public String City;
  public String Region;
  public String PostalCode;
  public String Country;
  public String Phone;
  public String Fax;


  Customers()
  {

  }

  public void setCustomerID(String customerID)
  {
    this.CustomerID = customerID;
  }

  public void setCompanyName(String companyName)
  {
    this.CompanyName = companyName;
  }

  public void setContactName(String contactName)
  {
    this.ContactName = contactName;
  }

  public void setContactTitle(String contactTitle)
  {
    this.ContactTitle = contactTitle;
  }

  public void setAddress(String addres)
  {
    this.Address = addres;
  }

  public void setRegioDetail(String city, String region, String postalC, String country)
  {
    this.City = city;
    this.Region = region;
    this.PostalCode = postalC;
    this.Country = country;
  }

  public void setContactDetail(String phone, String fax){
    this.Phone = phone;
    this.Fax = fax;
  }

  public String toString()
  {
    String output = CustomerID;

    return output;
  }


  @Override
  public int compareTo(Customers o)
  {
      if(this.CompanyName.compareTo(o.CompanyName) > 0)
        return 1;
      if(this.CompanyName.compareTo(o.CompanyName) < 0)
        return -1;
      if(this.CompanyName.compareTo(o.CompanyName) == 0)
        return 0;
  }

}
