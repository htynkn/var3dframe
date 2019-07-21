package var3d.net.center.freefont;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.FloatArray;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by feng on 2019/3/5.
 */

public class FreeBitmapFontData extends BitmapFont.BitmapFontData {

    public boolean isBreakChar(char c) {
        if (breakChars != null) {
            return super.isBreakChar(c);
        } else {
            if (isChinese("" + c, "[\u4E00-\u9FA5\uF900-\uFA2D\u3040-\u309F\u30A0-\u30FF]"))
                return true;
            return false;
        }
    }


    public static boolean isChinese(String str, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    public void getGlyphs (GlyphLayout.GlyphRun run, CharSequence str, int start, int end, boolean tightBounds) {
        //Gdx.app.log("aaaaaa","告诉我，你执行了"+str.subSequence(start,end));
       super.getGlyphs(run,str,start,end,tightBounds);
    }
}
