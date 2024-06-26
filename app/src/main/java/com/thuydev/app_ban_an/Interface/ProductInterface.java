package com.thuydev.app_ban_an.Interface;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thuydev.app_ban_an.Account.Account;
import com.thuydev.app_ban_an.Account.Accountfeedback;
import com.thuydev.app_ban_an.Account.ChangePasswordRequest;
import com.thuydev.app_ban_an.DTO.Bill;
import com.thuydev.app_ban_an.DTO.BillDetail;
import com.thuydev.app_ban_an.DTO.CartDTO;
import com.thuydev.app_ban_an.DTO.CategoryDTO;
import com.thuydev.app_ban_an.DTO.ProductDTO;
import com.thuydev.app_ban_an.DTO.ProductDetailDTO;
import com.thuydev.app_ban_an.DTO.Recharge;

import java.util.HashMap;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface ProductInterface {
    public static String BASE_URL = "http://10.0.2.2:3000/";
    public static String BASE_URL_IMAGE = "http://10.0.2.2:3000";
    public static String diachi = "dia chi Fake";

    public static ProductInterface GETAPI() {

        // Tạo Gson converter
        Gson gson = new GsonBuilder().setLenient().create();

        // Khởi tạo Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        // Tạo interface
        return retrofit.create(ProductInterface.class);
    }

    @GET("apiuser/product")
    Call<List<ProductDTO>> GetListProducts();

    @GET("apiuser/product/{id}")
    Call<ProductDTO> GetProduct(@Path("id") String id);

    @GET("apiuser/productdetail")
    Call<List<ProductDetailDTO>> GetProductDetails();

    @GET("apiuser/productdetail/{id}")
    Call<ProductDetailDTO> GetProductDetail(@Path("id") String id);

    @GET("apiuser/category")
    Call<List<CategoryDTO>> GetListCategory();
    @GET("apiuser/category/{id}")
    Call<CategoryDTO> GetCategory(@Path("id")String id);
    @GET("apiuser/product/category/{id}")
    Call<List<ProductDTO>> GetListProductToCate(@Path("id") String id);

    @GET("apiuser/user/cart/{id}")
    Call<List<CartDTO>> GetListCarts(@Path("id") String id);

    @POST("apiuser/user/cart/add")
    Call<String> AddCart(@Body CartDTO dto);

    @PUT("apiuser/cart/edit/{id}")
    Call<String> EditCart(@Path("id") String id);

    @DELETE("apiuser/cart/delete/{id}")
    Call<String> DeleteCart(@Path("id") String id);

    @POST("apiuser/bill/add")
    Call<String> AddBill(@Body HashMap<String, Object> Data);

    @GET("apiuser/user/bill/{id}")
    Call<List<Bill>> GetBills(@Path("id") String id);
    @GET("apiuser/bill/{id}")
    Call<Bill> GetBill(@Path("id") String id);
    @GET("apiuser/user/billdetail/{id}")
    Call<List<BillDetail>> GetBillDetails(@Path("id") String id);
    @GET("apiuser/user/billdetail/{id}/{firt}/{end}")
    Call<List<BillDetail>> GetBillDetailsToMonth(@Path("id") String id,@Path("firt")String firt,@Path("end")String end);
    @POST("apiuser/Reg")
    Call<Accountfeedback> accountfeedback(@Body Account account);

    @POST("apiuser/login")
    Call<Account> login(@Body Account account);

    @PUT("apiuser/changepassword")
    Call<ResponseBody> changePassword(@Body ChangePasswordRequest request);


    @PUT("apiuser/user/update/{id}")
    Call<String> UpdateProfile(@Path("id") String id, @Body() Account account);
    @Multipart
    @PUT("apiuser/user/update/{id}")
    Call<String> UpdateProfile(@Path("id") String id,
                               @Part() MultipartBody.Part avt,
                               @Part("Email") RequestBody Email,
                               @Part("FullName") RequestBody FullName,
                               @Part("NumberPhone") RequestBody NumberPhone);

    @GET("apiuser/Account")
    Call<List<Account>> GetListAccount();
    @GET("apiuser/DsBill")
    Call<List<BillDetail>> GetListxacnhan();
    // xóa ẩn(đổi status)
    @PUT("apiuser/xoahoadon/{id}")
    Call<Void> Xoahoadon(@Path("id") String id,@Body()Bill bill);
    @PUT("apiuser/chapnhanhoadon/{id}")
    Call<Void> chapnhanhoadon(@Path("id") String id,@Body()Bill bill );

    @Multipart
    @POST("apiuser/user/recharge")
    Call<String> YeuCauNap(@Part() MultipartBody.Part image,
                           @Part("Email") RequestBody Email,
                           @Part("IDUser") RequestBody IDUser,
                           @Part("Money") RequestBody Money,
                           @Part("Time") RequestBody Time);
    @GET("apiuser/user/recharge/{id}")
    Call<List<Recharge>> GetRecharge(@Path("id")String id);
}
