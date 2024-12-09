package utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.internal.LinkedTreeMap;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {
    private static <T> List<T> getListFromJsonArray(String pathOfJsonFile) {
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
}
