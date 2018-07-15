package ui.view;

import org.apache.commons.collections15.Transformer;

public class BooleanToSiNoTransformer implements Transformer<Boolean, String> {

	@Override
	public String transform(Boolean aprobo) {
		if (aprobo) {
			return "si";
		}
		return "no";
	}

}
