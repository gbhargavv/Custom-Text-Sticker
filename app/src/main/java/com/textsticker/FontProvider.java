package com.textsticker;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FontProvider {
    private static final String DEFAULT_FONT_CATEGORY = "Basic";
    private static final String DEFAULT_FONT_NAME = "Basic 1";
    private final Activity activity;
    private List<String> fontNames;
    private final Map<String, String> map3D = new HashMap();
    private final Map<String, String> mapBasic = new HashMap();
    private final Map<String, String> mapBrush = new HashMap();
    private final Map<String, String> mapCalligraphy = new HashMap();
    private final Map<String, String> mapComic = new HashMap();
    private final Map<String, String> mapDecorative = new HashMap();
    private final Map<String, String> mapGothic = new HashMap();
    private final Map<String, String> mapHolidays = new HashMap();
    private final Map<String, String> mapRetro = new HashMap();
    private final Map<String, String> mapStencilArmy = new HashMap();
    private final Resources resources;
    private final Map<String, Typeface> typefaces = new HashMap();

    public String getDefaultFontCategory() {
        return DEFAULT_FONT_CATEGORY;
    }

    public String getDefaultFontName() {
        return DEFAULT_FONT_NAME;
    }

    public FontProvider(Activity activity2, Resources resources2) {
        this.activity = activity2;
        this.resources = resources2;
        try {
            Iterator it = getFontList("3D").iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                this.map3D.put(getFontName(str), str);
            }
            Iterator it2 = getFontList(DEFAULT_FONT_CATEGORY).iterator();
            while (it2.hasNext()) {
                String str2 = (String) it2.next();
                this.mapBasic.put(getFontName(str2), str2);
            }
            Iterator it3 = getFontList("Brush").iterator();
            while (it3.hasNext()) {
                String str3 = (String) it3.next();
                this.mapBrush.put(getFontName(str3), str3);
            }
            Iterator it4 = getFontList("Calligraphy").iterator();
            while (it4.hasNext()) {
                String str4 = (String) it4.next();
                this.mapCalligraphy.put(getFontName(str4), str4);
            }
            Iterator it5 = getFontList("Comic").iterator();
            while (it5.hasNext()) {
                String str5 = (String) it5.next();
                this.mapComic.put(getFontName(str5), str5);
            }
            Iterator it6 = getFontList("Decorative").iterator();
            while (it6.hasNext()) {
                String str6 = (String) it6.next();
                this.mapDecorative.put(getFontName(str6), str6);
            }
            Iterator it7 = getFontList("Gothic").iterator();
            while (it7.hasNext()) {
                String str7 = (String) it7.next();
                this.mapGothic.put(getFontName(str7), str7);
            }
            Iterator it8 = getFontList("Retro").iterator();
            while (it8.hasNext()) {
                String str8 = (String) it8.next();
                this.mapRetro.put(getFontName(str8), str8);
            }
            Iterator it9 = getFontList("Stencil Army").iterator();
            while (it9.hasNext()) {
                String str9 = (String) it9.next();
                this.mapStencilArmy.put(getFontName(str9), str9);
            }
            Iterator it10 = getFontList("Holidays").iterator();
            while (it10.hasNext()) {
                String str10 = (String) it10.next();
                this.mapHolidays.put(getFontName(str10), str10);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Typeface getTypeface(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return Typeface.DEFAULT;
        }
        if (this.typefaces.get(str2) == null) {
            if (getTypeFace(str, str2) != null) {
                Map<String, Typeface> map = this.typefaces;
                AssetManager assets = this.resources.getAssets();
                StringBuilder sb = new StringBuilder();
                sb.append("Fonts/");
                sb.append(str);
                sb.append("/");
                sb.append(getTypeFace(str, str2));
                map.put(str2, Typeface.createFromAsset(assets, sb.toString()));
            } else {
                Map<String, Typeface> map2 = this.typefaces;
                AssetManager assets2 = this.resources.getAssets();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Fonts/Basic/");
                String str3 = DEFAULT_FONT_NAME;
                sb2.append(getTypeFace(DEFAULT_FONT_CATEGORY, str3));
                map2.put(str3, Typeface.createFromAsset(assets2, sb2.toString()));
            }
        }
        return (Typeface) this.typefaces.get(str2);
    }

    public List<String> getFontNames(String var1) {
        byte var2;
        label58: {
            switch(var1.hashCode()) {
                case -1521798719:
                    if (var1.equals("Stencil Army")) {
                        var2 = 8;
                        break label58;
                    }
                    break;
                case -446019781:
                    if (var1.equals("Holidays")) {
                        var2 = 9;
                        break label58;
                    }
                    break;
                case 1649:
                    if (var1.equals("3D")) {
                        var2 = 0;
                        break label58;
                    }
                    break;
                case 63955982:
                    if (var1.equals("Basic")) {
                        var2 = 1;
                        break label58;
                    }
                    break;
                case 64464666:
                    if (var1.equals("Brush")) {
                        var2 = 2;
                        break label58;
                    }
                    break;
                case 65290811:
                    if (var1.equals("Comic")) {
                        var2 = 4;
                        break label58;
                    }
                    break;
                case 78852734:
                    if (var1.equals("Retro")) {
                        var2 = 7;
                        break label58;
                    }
                    break;
                case 1182766496:
                    if (var1.equals("Decorative")) {
                        var2 = 5;
                        break label58;
                    }
                    break;
                case 1345461846:
                    if (var1.equals("Calligraphy")) {
                        var2 = 3;
                        break label58;
                    }
                    break;
                case 2138739606:
                    if (var1.equals("Gothic")) {
                        var2 = 6;
                        break label58;
                    }
            }

            var2 = -1;
        }

        switch(var2) {
            case 0:
                this.fontNames = new ArrayList(this.map3D.keySet());
                break;
            case 1:
                this.fontNames = new ArrayList(this.mapBasic.keySet());
                break;
            case 2:
                this.fontNames = new ArrayList(this.mapBrush.keySet());
                break;
            case 3:
                this.fontNames = new ArrayList(this.mapCalligraphy.keySet());
                break;
            case 4:
                this.fontNames = new ArrayList(this.mapComic.keySet());
                break;
            case 5:
                this.fontNames = new ArrayList(this.mapDecorative.keySet());
                break;
            case 6:
                this.fontNames = new ArrayList(this.mapGothic.keySet());
                break;
            case 7:
                this.fontNames = new ArrayList(this.mapRetro.keySet());
                break;
            case 8:
                this.fontNames = new ArrayList(this.mapStencilArmy.keySet());
                break;
            case 9:
                this.fontNames = new ArrayList(this.mapHolidays.keySet());
        }

        return this.fontNames;
    }

    private String getFontName(String str) {
        return str.replace(str.substring(str.indexOf(".")), "");
    }

    private String getTypeFace(String var1, String var2) {
        byte var3;
        label54: {
            switch(var1.hashCode()) {
                case -1521798719:
                    if (var1.equals("Stencil Army")) {
                        var3 = 8;
                        break label54;
                    }
                    break;
                case -446019781:
                    if (var1.equals("Holidays")) {
                        var3 = 9;
                        break label54;
                    }
                    break;
                case 1649:
                    if (var1.equals("3D")) {
                        var3 = 0;
                        break label54;
                    }
                    break;
                case 63955982:
                    if (var1.equals("Basic")) {
                        var3 = 1;
                        break label54;
                    }
                    break;
                case 64464666:
                    if (var1.equals("Brush")) {
                        var3 = 2;
                        break label54;
                    }
                    break;
                case 65290811:
                    if (var1.equals("Comic")) {
                        var3 = 4;
                        break label54;
                    }
                    break;
                case 78852734:
                    if (var1.equals("Retro")) {
                        var3 = 7;
                        break label54;
                    }
                    break;
                case 1182766496:
                    if (var1.equals("Decorative")) {
                        var3 = 5;
                        break label54;
                    }
                    break;
                case 1345461846:
                    if (var1.equals("Calligraphy")) {
                        var3 = 3;
                        break label54;
                    }
                    break;
                case 2138739606:
                    if (var1.equals("Gothic")) {
                        var3 = 6;
                        break label54;
                    }
            }

            var3 = -1;
        }

        switch(var3) {
            case 0:
                return (String)this.map3D.get(var2);
            case 1:
                return (String)this.mapBasic.get(var2);
            case 2:
                return (String)this.mapBrush.get(var2);
            case 3:
                return (String)this.mapCalligraphy.get(var2);
            case 4:
                return (String)this.mapComic.get(var2);
            case 5:
                return (String)this.mapDecorative.get(var2);
            case 6:
                return (String)this.mapGothic.get(var2);
            case 7:
                return (String)this.mapRetro.get(var2);
            case 8:
                return (String)this.mapStencilArmy.get(var2);
            case 9:
                return (String)this.mapHolidays.get(var2);
            default:
                return "";
        }
    }

    private ArrayList<String> getFontList(String str) throws IOException {
        AssetManager assets = this.activity.getAssets();
        StringBuilder sb = new StringBuilder();
        sb.append("Fonts/");
        sb.append(str);
        return new ArrayList<>(Arrays.asList(assets.list(sb.toString())));
    }

    public int getFontPosition(String str, String str2) {
        return getFontNames(str).indexOf(str2);
    }
}
