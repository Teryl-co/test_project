package by.lynd.hotels.JSON;




import by.lynd.hotels.Model.HotelList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("9d675851-9d19-42f7-a736-8f195e6cf449")
    Call<HotelList> loadHotels();

}
