package dataprovider;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.internal.LinkedTreeMap;
import dto.RegisterPaidTraining;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Provider {
    @DataProvider
    public static Object[][] netlifySearchKeywords() {
        return new Object[][]{{"john"}, {"kathy"}, {"peter"}};
    }

    @DataProvider
    public static Object[][] getData() {
        return generate2DimArray(RegisterPaidTraining.class, "src/test/dataprovider/register.json");
    }


    public static RegisterPaidTraining initDataForRegistering() {
        Gson gson = new Gson();
        RegisterPaidTraining register;
        try (Reader reader = new FileReader("src/test/dataprovider/register.json")) {
            register = gson.fromJson(reader, RegisterPaidTraining.class);
            System.out.println(register);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return register;
    }

    public static <T> List<T> getListFromJsonArray(String pathOfJsonFile) {
        Gson gson = new Gson();
        List<T> yourClassList;
        try (Reader reader = new FileReader(pathOfJsonFile)) {
            Type listType = new TypeToken<ArrayList<T>>() {
            }.getType();
            yourClassList = gson.fromJson(reader, listType);
            return yourClassList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> Object[][] generate2DimArray(Class<T> tClass, String pathOfJson) {
        Gson gson = new Gson();
        List<T> listData = getListFromJsonArray(pathOfJson);
        Object[][] result = new Object[listData.size()][1];
        for (int index = 0; index < result.length; index++) {
            LinkedTreeMap tree = (LinkedTreeMap) listData.get(index);
            JsonElement element = gson.toJsonTree(tree);
            Object[] item = result[index];
            item[0] = gson.fromJson(element, tClass);
        }
        return result;
    }

    public static <T> T get(T input) {
        return input;
    }


}
