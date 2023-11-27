package es.jsomoza.fileupload;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;

@Component
public class PictureCommandToPicture 
		implements Converter<PictureCommand, Picture>{

    @Synchronized
    @Nullable
    @Override
	public Picture convert(PictureCommand pictureCommand) {
        if (pictureCommand == null) {
            return null;
        }

        final Picture picture = new Picture();
        picture.setId(pictureCommand.getId());
        picture.setName(pictureCommand.getName());
        picture.setContent(pictureCommand.getContent());
        return picture;
	}
}