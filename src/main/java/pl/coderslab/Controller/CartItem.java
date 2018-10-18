package pl.coderslab.Controller;

public class CartItem
{
    private String name;
    private int quantity;
    private double price;

    public CartItem(String name, int quantity, double price)
    {
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getPrice()
    {
        return price;
    }
}
