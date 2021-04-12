package br.com.gestaohoras.api.adapters;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class LocalTimeAdapter implements JsonSerializer<LocalTime> {

	@Override
	public JsonElement serialize(LocalTime src, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("HH:mm")));
	}

}
