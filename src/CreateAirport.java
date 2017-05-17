/**
 *  Create Airport
 */
public class CreateAirport {
    public Airport atl = new Airport("ATL", 10, 10);
    public Airport jfk = new Airport("JFK", 10, 10);
    public Airport bos = new Airport("BOS", 10, 10);
    public Airport ord = new Airport("ORD", 11, 15);
    public Airport lax = new Airport("LAX", 12, 17);

    public Airport returnAirport(int code){
        Airport return_value = null;
        switch (code){
            case 1:
                return_value = this.atl;
                break;
            case 2:
                return_value = this.jfk;
                break;
            case 3:
                return_value = this.bos;
                break;
            case 4:
                return_value = this.ord;
                break;
            case 5:
                return_value = this.lax;
                break;
        }

        return return_value;
    }
}
