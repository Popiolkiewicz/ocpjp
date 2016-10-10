package misc;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 
 */

/**
 * Created on 8 maj 2016 - 19:13:37
 *
 * @author Hubert
 */
public class SimpleDateFormatTester {
    // G y Y M w W D d F E u a H k K h m s S z Z X
	public static void main(String[] args) {
		try { testLetters(); } catch (Exception e) { e.printStackTrace(); }
	}

	private static void testLetters() {
		Date date = new Date(1000000000000L);
		System.out.println(date); // Sun Sep 09 03:46:40 CEST 2001
		// new SimpleDateFormat("t").format(new Date()); // java.lang.IllegalArgumentException: Illegal pattern character 't'
		// new SimpleDateFormat("tt").format(new Date()); // java.lang.IllegalArgumentException: Illegal pattern character 't'
		// new SimpleDateFormat("ttt").format(new Date()); // java.lang.IllegalArgumentException: Illegal pattern character 't'
		// new SimpleDateFormat("tttt").format(new Date()); // java.lang.IllegalArgumentException: Illegal pattern character 't'
		
		//Era designator
		System.out.println(new SimpleDateFormat("G", Locale.US).format(date)); //AD
		System.out.println(new SimpleDateFormat("GG", Locale.US).format(date)); //AD
		System.out.println(new SimpleDateFormat("GGG", Locale.US).format(date)); //AD
		System.out.println(new SimpleDateFormat("GGGG", Locale.US).format(date)); //AD
		System.out.println(new SimpleDateFormat("GGGGG", Locale.US).format(date)); //AD
		
		//Year
		System.out.println(new SimpleDateFormat("y", Locale.US).format(date)); //2001
		System.out.println(new SimpleDateFormat("yy", Locale.US).format(date)); //01
		System.out.println(new SimpleDateFormat("yyy", Locale.US).format(date)); //2001
		System.out.println(new SimpleDateFormat("yyyy", Locale.US).format(date)); //2001
		System.out.println(new SimpleDateFormat("yyyyy", Locale.US).format(date)); //02001
		
		//Week Year
		System.out.println(new SimpleDateFormat("Y", Locale.US).format(date)); //2001
		System.out.println(new SimpleDateFormat("YY", Locale.US).format(date)); //01
		System.out.println(new SimpleDateFormat("YYY", Locale.US).format(date)); //2001
		System.out.println(new SimpleDateFormat("YYYY", Locale.US).format(date)); //2001
		System.out.println(new SimpleDateFormat("YYYYY", Locale.US).format(date)); //02001
		
		//Month in year
		System.out.println(new SimpleDateFormat("M", Locale.US).format(date)); //9
		System.out.println(new SimpleDateFormat("MM", Locale.US).format(date)); //09
		System.out.println(new SimpleDateFormat("MMM", Locale.US).format(date)); //Sep
		System.out.println(new SimpleDateFormat("MMMM", Locale.US).format(date)); //September
		System.out.println(new SimpleDateFormat("MMMMM", Locale.US).format(date)); //September
		System.out.println(new SimpleDateFormat("MMMMMM", Locale.US).format(date)); //September
		
		//Week in year
		System.out.println(new SimpleDateFormat("w", Locale.US).format(date)); //37
		System.out.println(new SimpleDateFormat("ww", Locale.US).format(date)); //37
		System.out.println(new SimpleDateFormat("www", Locale.US).format(date)); //037
		System.out.println(new SimpleDateFormat("wwww", Locale.US).format(date)); //0037
		System.out.println(new SimpleDateFormat("wwwww", Locale.US).format(date)); //00037
		
		//Week in month
		System.out.println(new SimpleDateFormat("W", Locale.US).format(date)); //3
		System.out.println(new SimpleDateFormat("WW", Locale.US).format(date)); //03
		System.out.println(new SimpleDateFormat("WWW", Locale.US).format(date)); //003
		System.out.println(new SimpleDateFormat("WWWW", Locale.US).format(date)); //0003
		System.out.println(new SimpleDateFormat("WWWWW", Locale.US).format(date)); //00003
		
		//Day in year
		System.out.println(new SimpleDateFormat("D", Locale.US).format(date)); //252
		System.out.println(new SimpleDateFormat("DD", Locale.US).format(date)); //252
		System.out.println(new SimpleDateFormat("DDD", Locale.US).format(date)); //252
		System.out.println(new SimpleDateFormat("DDDD", Locale.US).format(date)); //0252
		System.out.println(new SimpleDateFormat("DDDDD", Locale.US).format(date)); //00252
		
		//Day in month
		System.out.println(new SimpleDateFormat("d", Locale.US).format(date)); //9
		System.out.println(new SimpleDateFormat("dd", Locale.US).format(date)); //09
		System.out.println(new SimpleDateFormat("ddd", Locale.US).format(date)); //009
		System.out.println(new SimpleDateFormat("dddd", Locale.US).format(date)); //0009
		System.out.println(new SimpleDateFormat("ddddd", Locale.US).format(date)); //00009
		
		//Day of the week in the month
		System.out.println(new SimpleDateFormat("F", Locale.US).format(date)); //2
		System.out.println(new SimpleDateFormat("FF", Locale.US).format(date)); //02
		System.out.println(new SimpleDateFormat("FFF", Locale.US).format(date)); //002
		System.out.println(new SimpleDateFormat("FFFF", Locale.US).format(date)); //0002
		System.out.println(new SimpleDateFormat("FFFFF", Locale.US).format(date)); //00002
		
		// Day name in week
		System.out.println(new SimpleDateFormat("E", Locale.US).format(date)); //Sun
		System.out.println(new SimpleDateFormat("EE", Locale.US).format(date)); //Sun
		System.out.println(new SimpleDateFormat("EEE", Locale.US).format(date)); //Sun
		System.out.println(new SimpleDateFormat("EEEE", Locale.US).format(date)); //Sunday
		System.out.println(new SimpleDateFormat("EEEEE", Locale.US).format(date)); //Sunday
		System.out.println(new SimpleDateFormat("EEEEEEEEEEEE", Locale.US).format(date)); //Sunday
		
		// Day number of week (1 = Monday, ..., 7 = Sunday)
		System.out.println(new SimpleDateFormat("u", Locale.US).format(date)); //7
		System.out.println(new SimpleDateFormat("uu", Locale.US).format(date)); //07
		System.out.println(new SimpleDateFormat("uuu", Locale.US).format(date)); //007
		System.out.println(new SimpleDateFormat("uuuu", Locale.US).format(date)); //0007
		System.out.println(new SimpleDateFormat("uuuuu", Locale.US).format(date)); //00007
		
		// am/pm marker
		System.out.println(new SimpleDateFormat("a", Locale.US).format(date)); //AM
		System.out.println(new SimpleDateFormat("aa", Locale.US).format(date)); //AM
		System.out.println(new SimpleDateFormat("aaa", Locale.US).format(date)); //AM
		System.out.println(new SimpleDateFormat("aaaa", Locale.US).format(date)); //AM
		System.out.println(new SimpleDateFormat("aaaaa", Locale.US).format(date)); //AM
		
		// Hour in day (0-23)
		System.out.println(new SimpleDateFormat("H", Locale.US).format(date)); //3
		System.out.println(new SimpleDateFormat("HH", Locale.US).format(date)); //03
		System.out.println(new SimpleDateFormat("HHH", Locale.US).format(date)); //003
		System.out.println(new SimpleDateFormat("HHHH", Locale.US).format(date)); //0003
		System.out.println(new SimpleDateFormat("HHHHH", Locale.US).format(date)); //00003
		
		// Hour in am/pm (1-12)
		System.out.println(new SimpleDateFormat("h", Locale.US).format(date)); //3
		System.out.println(new SimpleDateFormat("hh", Locale.US).format(date)); //03
		System.out.println(new SimpleDateFormat("hhh", Locale.US).format(date)); //003
		System.out.println(new SimpleDateFormat("hhhh", Locale.US).format(date)); //0003
		System.out.println(new SimpleDateFormat("hhhhh", Locale.US).format(date)); //00003
		
		// Hour in am/pm (0-11)
		System.out.println(new SimpleDateFormat("K", Locale.US).format(date)); //3
		System.out.println(new SimpleDateFormat("KK", Locale.US).format(date)); //03
		System.out.println(new SimpleDateFormat("KKK", Locale.US).format(date)); //003
		System.out.println(new SimpleDateFormat("KKKK", Locale.US).format(date)); //0003
		System.out.println(new SimpleDateFormat("KKKKK", Locale.US).format(date)); //00003
		
		// Hour in day (1-24)
		System.out.println(new SimpleDateFormat("k", Locale.US).format(date)); //3
		System.out.println(new SimpleDateFormat("kk", Locale.US).format(date)); //03
		System.out.println(new SimpleDateFormat("kkk", Locale.US).format(date)); //003
		System.out.println(new SimpleDateFormat("kkkk", Locale.US).format(date)); //0003
		System.out.println(new SimpleDateFormat("kkkkk", Locale.US).format(date)); //00003
		
		// Minute in hour
		System.out.println(new SimpleDateFormat("m", Locale.US).format(date)); //46
		System.out.println(new SimpleDateFormat("mm", Locale.US).format(date)); //46
		System.out.println(new SimpleDateFormat("mmm", Locale.US).format(date)); //046
		System.out.println(new SimpleDateFormat("mmmm", Locale.US).format(date)); //0046
		System.out.println(new SimpleDateFormat("mmmmm", Locale.US).format(date)); //00046
		
		// Second in minute
		System.out.println(new SimpleDateFormat("s", Locale.US).format(date)); //40
		System.out.println(new SimpleDateFormat("ss", Locale.US).format(date)); //40
		System.out.println(new SimpleDateFormat("sss", Locale.US).format(date)); //040
		System.out.println(new SimpleDateFormat("ssss", Locale.US).format(date)); //0040
		System.out.println(new SimpleDateFormat("sssss", Locale.US).format(date)); //00040
		
		// Millisecond
		System.out.println(new SimpleDateFormat("S", Locale.US).format(date)); //0
		System.out.println(new SimpleDateFormat("SS", Locale.US).format(date)); //00
		System.out.println(new SimpleDateFormat("SSS", Locale.US).format(date)); //000
		System.out.println(new SimpleDateFormat("SSSS", Locale.US).format(date)); //0000
		System.out.println(new SimpleDateFormat("SSSSS", Locale.US).format(date)); //00000
		
		// Timezone - General time zone
		System.out.println(new SimpleDateFormat("z", Locale.US).format(date)); //CEST
		System.out.println(new SimpleDateFormat("zz", Locale.US).format(date)); //CEST
		System.out.println(new SimpleDateFormat("zzz", Locale.US).format(date)); //CEST
		System.out.println(new SimpleDateFormat("zzzz", Locale.US).format(date)); //Central European Summer Time
		System.out.println(new SimpleDateFormat("zzzzz", Locale.US).format(date)); //Central European Summer Time
		
		// Timezone - RFC 822
		System.out.println(new SimpleDateFormat("Z", Locale.US).format(date)); //+0200
		System.out.println(new SimpleDateFormat("ZZ", Locale.US).format(date)); //+0200
		System.out.println(new SimpleDateFormat("ZZZ", Locale.US).format(date)); //+0200
		System.out.println(new SimpleDateFormat("ZZZZ", Locale.US).format(date)); //+0200
		System.out.println(new SimpleDateFormat("ZZZZZ", Locale.US).format(date)); //+0200
		
		// Timezone - ISO 8601
		System.out.println(new SimpleDateFormat("X", Locale.US).format(date)); //+02
		System.out.println(new SimpleDateFormat("XX", Locale.US).format(date)); //+0200
		System.out.println(new SimpleDateFormat("XXX", Locale.US).format(date)); //+02:00
		// System.out.println(new SimpleDateFormat("XXXX", Locale.US).format(date)); // java.lang.IllegalArgumentException: invalid ISO 8601 format: length=4
		// System.out.println(new SimpleDateFormat("XXXXX", Locale.US).format(date)); // java.lang.IllegalArgumentException: invalid ISO 8601 format: length=5
	}
}
