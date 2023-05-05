package com.example.carshowroom.Data.DataSource;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.carshowroom.DB.BrandDao;
import com.example.carshowroom.DB.BrandDataBase;
import com.example.carshowroom.Data.Models.Brand;

import java.util.ArrayList;
import java.util.List;

public class BrandDataSource {
    private final Context context;

    public BrandDataSource(Context context) {
        this.context = context;
    }

    public LiveData<List<Brand>> getBrandList() {
        List<Brand> brandList = new ArrayList<>();

        String[] all_brands = {
                "Abarth",
                "Acura",
                "Alfa Romeo",
                "Alpine",
                "AMC",
                "Ariel",
                "Aston Martin",
                "Audi",
                "Austin",
                "Austin-Healey",
                "AvtoVAZ",
                "BAIC",
                "Bentley",
                "BMW",
                "Borgward",
                "Brilliance",
                "Bristol",
                "Bugatti",
                "Buick",
                "BYD",
                "Cadillac",
                "Callaway",
                "Caparo",
                "Caterham",
                "Changan",
                "Chery",
                "Chevrolet",
                "Chrysler",
                "Citroen",
                "Cizeta",
                "Conquest",
                "Dacia",
                "Daewoo",
                "Daihatsu",
                "Daimler",
                "Datsun",
                "De Tomaso",
                "Delage",
                "DeLorean",
                "DeltaWing",
                "Denzel",
                "DeSoto",
                "Detroit Electric",
                "Dodge",
                "Donkervoort",
                "DS",
                "Eagle",
                "EDAG",
                "Elfin",
                "Faraday Future",
                "Ferrari",
                "Fiat",
                "Fisker",
                "Ford",
                "Foton",
                "GAC",
                "GAZ",
                "Geely",
                "Genesis",
                "Ginetta",
                "GMC",
                "Gumpert",
                "Hennessey",
                "Hillman",
                "Holden",
                "Honda",
                "Hongqi",
                "HSV",
                "Hudson",
                "Hummer",
                "Hyundai",
                "Infiniti",
                "Innocenti",
                "Isdera",
                "Isuzu",
                "Iveco",
                "JAC",
                "Jaguar",
                "Jeep",
                "Jensen",
                "Jetcar",
                "Jiangling",
                "Joss",
                "Kamaz",
                "Karma",
                "KIA",
                "Koenigsegg",
                "Lada",
                "Lamborghini",
                "Lancia",
                "Land Rover",
                "Landwind",
                "Lexus",
                "Leyland",
                "Lincoln",
                "Lobini",
                "Lotus",
                "Lynk &amp; Co",
                "Mahindra",
                "Marcos",
                "Marlin",
                "Maserati",
                "Mastretta",
                "Maybach",
                "Mazda",
                "McLaren",
                "Mercedes-Benz",
                "Mercury",
                "MG",
                "Microcar",
                "Mini",
                "Mitsubishi",
                "Mitsuoka",
                "Morgan",
                "Morris",
                "Moskvitch",
                "Nio",
                "Nissan",
                "Noble",
                "NSU",
                "Oldsmobile",
                "Opel",
                "Osca",
                "Packard",
                "Pagani",
                "Panther",
                "Perodua",
                "Peugeot",
                "Pininfarina",
                "Plymouth",
                "Polestar",
                "Pontiac",
                "Porsche",
                "Proton",
                "Puch",
                "Qoros",
                "Qvale",
                "Radical",
                "Ram",
                "Ranz",
                "Renault",
                "Rezvani",
                "Rimac",
                "Riley",
                "Rolls-Royce",
                "Ronart",
                "Rover",
                "Ruf",
                "Saab",
                "Saleen",
                "Sbarro",
                "Scania",
                "Scion",
                "SEAT",
                "Shelby",
                "Shuanghuan",
                "Singer",
                "Skoda",
                "Smart",
                "SsangYong",
                "SSC",
                "Steyr",
                "Studebaker",
                "Subaru",
                "Sunbeam",
                "Suzuki",
                "Talbot",
                "Tata",
                "Tatra",
                "Tesla",
                "Think",
                "Toyota",
                "Trabant",
                "Triumph",
                "TVR",
                "Ultima",
                "Vandenbrink",
                "Vauxhall",
                "Vector",
                "Venturi",
                "Vespa",
                "Volkswagen",
                "Volvo",
                "Wartburg",
                "Westfield",
                "Wiesmann",
                "Willys",
                "Wuling",
                "Xpeng",
                "Yugo",
                "Zastava",
                "ZAZ",
                "Zenos",
                "Zenvo",
                "ZIL",
                "Zimmer",
                "Zotye",
                "Zundapp",
                "ZX",
                "АЗЛК"
        };


        for (String brand : all_brands) {
            brandList.add(new Brand(brand));
        }

        BrandDataBase dataBase = BrandDataBase.getDatabase(context);
        BrandDao brandDao = dataBase.brandDao();
        dataBase.getQueryExecutor().execute(() -> {
            for (Brand brand : brandList) {
                brandDao.insert(brand);
                Log.d("log", brand.name);
            }
        });
        return brandDao.getBrandList();
    }
}
