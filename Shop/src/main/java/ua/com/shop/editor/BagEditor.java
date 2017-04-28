package ua.com.shop.editor;

import java.beans.PropertyEditorSupport;

import ua.com.shop.service.BagService;

public class BagEditor extends PropertyEditorSupport {

	private final BagService bagService;

	public BagEditor(BagService bagService) {
		this.bagService = bagService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(bagService.findOne(Integer.parseInt(text)));
	}

}
