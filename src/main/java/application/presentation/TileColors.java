package application.presentation;

import javafx.scene.paint.Color;

public class TileColors {

	//just saving the colors here as a static array
	public static Color[] Back = {
			Color.BLACK,
			Color.DARKGRAY
	};

	
	//not used anymore
	public static Color[] colortiles = {
			Color.DARKGREEN,
			Color.DARKBLUE,
			Color.CADETBLUE,
			Color.DEEPPINK,
			Color.DARKRED,
			Color.ALICEBLUE,
			Color.ANTIQUEWHITE,
			Color.AQUA,


			Color.AZURE,
			Color.BEIGE,
			Color.BISQUE,
			Color.BLANCHEDALMOND,
			Color.CRIMSON,
			Color.BLUE,
			Color.BLUEVIOLET,
			Color.BROWN,
			Color.BURLYWOOD,
			Color.AQUAMARINE,
			Color.CHARTREUSE,
			Color.CHOCOLATE,
			Color.CORAL,
			Color.CORNFLOWERBLUE,
			Color.CORNSILK,

			Color.CYAN,

			Color.DARKCYAN,
			Color.DARKGOLDENROD,

			Color.DARKKHAKI,
			Color.DARKMAGENTA,
			Color.DARKOLIVEGREEN,
			Color.DARKORANGE,

			Color.DARKSALMON,
			Color.DARKSEAGREEN,
			Color.DARKSLATEBLUE,
			Color.DARKTURQUOISE,
			Color.DARKVIOLET,

			Color.DEEPSKYBLUE,
			Color.DODGERBLUE,
			Color.FIREBRICK,
			Color.FORESTGREEN,
			Color.FUCHSIA,
			Color.GAINSBORO,
			Color.GOLD,
			Color.GREEN,
			Color.GREENYELLOW,
			Color.HONEYDEW,
			Color.HOTPINK,
			Color.INDIANRED,
			Color.INDIGO,
			Color.KHAKI,
			Color.LAVENDER,
			Color.LAVENDERBLUSH,
			Color.LAWNGREEN,
			Color.LEMONCHIFFON,
			Color.LIGHTCORAL,
			Color.LIGHTCYAN,
			Color.LIGHTPINK,
			Color.LIGHTSEAGREEN
	};

	public static Color[] getColortiles() {
		return colortiles;
	}

	public static void setColortiles(Color[] colortiles) {
		TileColors.colortiles = colortiles;
	}

	public static Color[] getBack() {
		return Back;
	}

	public static void setBack(Color[] back) {
		Back = back;
	}

}
