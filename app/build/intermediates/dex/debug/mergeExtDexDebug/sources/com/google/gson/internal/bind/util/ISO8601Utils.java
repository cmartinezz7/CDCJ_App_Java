package com.google.gson.internal.bind.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    private static final String UTC_ID = "UTC";

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean millis) {
        return format(date, millis, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean millis, TimeZone tz) {
        Calendar calendar = new GregorianCalendar(tz, Locale.US);
        calendar.setTime(date);
        StringBuilder formatted = new StringBuilder("yyyy-MM-ddThh:mm:ss".length() + (millis ? ".sss".length() : 0) + (tz.getRawOffset() == 0 ? "Z" : "+hh:mm").length());
        padInt(formatted, calendar.get(1), "yyyy".length());
        char c = '-';
        formatted.append('-');
        padInt(formatted, calendar.get(2) + 1, "MM".length());
        formatted.append('-');
        padInt(formatted, calendar.get(5), "dd".length());
        formatted.append('T');
        padInt(formatted, calendar.get(11), "hh".length());
        formatted.append(':');
        padInt(formatted, calendar.get(12), "mm".length());
        formatted.append(':');
        padInt(formatted, calendar.get(13), "ss".length());
        if (millis) {
            formatted.append('.');
            padInt(formatted, calendar.get(14), "sss".length());
        }
        int offset = tz.getOffset(calendar.getTimeInMillis());
        if (offset != 0) {
            int hours = Math.abs((offset / 60000) / 60);
            int minutes = Math.abs((offset / 60000) % 60);
            if (offset >= 0) {
                c = '+';
            }
            formatted.append(c);
            padInt(formatted, hours, "hh".length());
            formatted.append(':');
            padInt(formatted, minutes, "mm".length());
        } else {
            formatted.append('Z');
        }
        return formatted.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x0231  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0233  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date parse(java.lang.String r22, java.text.ParsePosition r23) throws java.text.ParseException {
        /*
            r1 = r22
            r2 = r23
            r3 = 0
            int r0 = r23.getIndex()     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            int r4 = r0 + 4
            int r0 = parseInt(r1, r0, r4)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            r5 = 45
            boolean r6 = checkOffset(r1, r4, r5)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            if (r6 == 0) goto L_0x0019
            int r4 = r4 + 1
        L_0x0019:
            int r6 = r4 + 2
            int r4 = parseInt(r1, r4, r6)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            boolean r7 = checkOffset(r1, r6, r5)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            if (r7 == 0) goto L_0x0027
            int r6 = r6 + 1
        L_0x0027:
            int r7 = r6 + 2
            int r6 = parseInt(r1, r6, r7)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 84
            boolean r12 = checkOffset(r1, r7, r12)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            if (r12 != 0) goto L_0x005d
            int r13 = r22.length()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0053, IllegalArgumentException -> 0x004e }
            if (r13 > r7) goto L_0x005d
            java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0053, IllegalArgumentException -> 0x004e }
            int r13 = r4 + -1
            r5.<init>(r0, r13, r6)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0053, IllegalArgumentException -> 0x004e }
            r2.setIndex(r7)     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0053, IllegalArgumentException -> 0x004e }
            java.util.Date r13 = r5.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x0058, NumberFormatException -> 0x0053, IllegalArgumentException -> 0x004e }
            return r13
        L_0x004e:
            r0 = move-exception
            r20 = r3
            goto L_0x0223
        L_0x0053:
            r0 = move-exception
            r20 = r3
            goto L_0x0228
        L_0x0058:
            r0 = move-exception
            r20 = r3
            goto L_0x022d
        L_0x005d:
            r13 = 43
            r14 = 90
            if (r12 == 0) goto L_0x00e8
            int r7 = r7 + 1
            int r15 = r7 + 2
            int r7 = parseInt(r1, r7, r15)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            r8 = r7
            r7 = 58
            boolean r16 = checkOffset(r1, r15, r7)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            if (r16 == 0) goto L_0x0076
            int r15 = r15 + 1
        L_0x0076:
            int r5 = r15 + 2
            int r15 = parseInt(r1, r15, r5)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            r9 = r15
            boolean r7 = checkOffset(r1, r5, r7)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            if (r7 == 0) goto L_0x0087
            int r5 = r5 + 1
            r7 = r5
            goto L_0x0088
        L_0x0087:
            r7 = r5
        L_0x0088:
            int r5 = r22.length()     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            if (r5 <= r7) goto L_0x00e5
            char r5 = r1.charAt(r7)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            if (r5 == r14) goto L_0x00e2
            if (r5 == r13) goto L_0x00e2
            r15 = 45
            if (r5 == r15) goto L_0x00e2
            int r15 = r7 + 2
            int r7 = parseInt(r1, r7, r15)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            r10 = 59
            if (r7 <= r10) goto L_0x00ac
            r10 = 63
            if (r7 >= r10) goto L_0x00ac
            r7 = 59
            r10 = r7
            goto L_0x00ad
        L_0x00ac:
            r10 = r7
        L_0x00ad:
            r7 = 46
            boolean r7 = checkOffset(r1, r15, r7)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            if (r7 == 0) goto L_0x00de
            int r15 = r15 + 1
            int r7 = r15 + 1
            int r7 = indexOfNonDigit(r1, r7)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            int r13 = r15 + 3
            int r13 = java.lang.Math.min(r7, r13)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            int r18 = parseInt(r1, r15, r13)     // Catch:{ IndexOutOfBoundsException -> 0x022a, NumberFormatException -> 0x0225, IllegalArgumentException -> 0x0220 }
            int r14 = r13 - r15
            r20 = r3
            r3 = 1
            if (r14 == r3) goto L_0x00d9
            r3 = 2
            if (r14 == r3) goto L_0x00d5
            r3 = r18
            r11 = r3
            goto L_0x00dc
        L_0x00d5:
            int r3 = r18 * 10
            r11 = r3
            goto L_0x00dc
        L_0x00d9:
            int r3 = r18 * 100
            r11 = r3
        L_0x00dc:
            r3 = r7
            goto L_0x00ea
        L_0x00de:
            r20 = r3
            r7 = r15
            goto L_0x00ea
        L_0x00e2:
            r20 = r3
            goto L_0x00ea
        L_0x00e5:
            r20 = r3
            goto L_0x00ea
        L_0x00e8:
            r20 = r3
        L_0x00ea:
            int r3 = r22.length()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            if (r3 <= r7) goto L_0x0210
            r3 = 0
            char r5 = r1.charAt(r7)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r13 = 5
            r14 = 90
            if (r5 != r14) goto L_0x0105
            java.util.TimeZone r14 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r3 = r14
            r14 = 1
            int r7 = r7 + r14
            r17 = r5
            r21 = r12
            goto L_0x01dd
        L_0x0105:
            r14 = 43
            if (r5 == r14) goto L_0x012d
            r14 = 45
            if (r5 != r14) goto L_0x010e
            goto L_0x012d
        L_0x010e:
            java.lang.IndexOutOfBoundsException r13 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r14.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.String r15 = "Invalid time zone indicator '"
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.StringBuilder r14 = r14.append(r5)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.String r15 = "'"
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.String r14 = r14.toString()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r13.<init>(r14)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            throw r13     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
        L_0x012d:
            java.lang.String r14 = r1.substring(r7)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            int r15 = r14.length()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            if (r15 < r13) goto L_0x0139
            r13 = r14
            goto L_0x014c
        L_0x0139:
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r15.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.StringBuilder r15 = r15.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.String r13 = "00"
            java.lang.StringBuilder r13 = r15.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.String r13 = r13.toString()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
        L_0x014c:
            int r14 = r13.length()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            int r7 = r7 + r14
            java.lang.String r14 = "+0000"
            boolean r14 = r14.equals(r13)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            if (r14 != 0) goto L_0x01d2
            java.lang.String r14 = "+00:00"
            boolean r14 = r14.equals(r13)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            if (r14 == 0) goto L_0x0169
            r17 = r5
            r18 = r7
            r21 = r12
            goto L_0x01d8
        L_0x0169:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r14.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.String r15 = "GMT"
            java.lang.StringBuilder r14 = r14.append(r15)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.StringBuilder r14 = r14.append(r13)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.String r14 = r14.toString()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.util.TimeZone r15 = java.util.TimeZone.getTimeZone(r14)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r3 = r15
            java.lang.String r15 = r3.getID()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            boolean r17 = r15.equals(r14)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            if (r17 != 0) goto L_0x01cb
            r17 = r5
            java.lang.String r5 = ":"
            r18 = r7
            java.lang.String r7 = ""
            java.lang.String r5 = r15.replace(r5, r7)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            boolean r7 = r5.equals(r14)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            if (r7 == 0) goto L_0x01a0
            r21 = r12
            goto L_0x01db
        L_0x01a0:
            java.lang.IndexOutOfBoundsException r7 = new java.lang.IndexOutOfBoundsException     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r19 = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r5.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r21 = r12
            java.lang.String r12 = "Mismatching time zone indicator: "
            java.lang.StringBuilder r5 = r5.append(r12)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.StringBuilder r5 = r5.append(r14)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.String r12 = " given, resolves to "
            java.lang.StringBuilder r5 = r5.append(r12)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.String r12 = r3.getID()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.StringBuilder r5 = r5.append(r12)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.String r5 = r5.toString()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r7.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            throw r7     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
        L_0x01cb:
            r17 = r5
            r18 = r7
            r21 = r12
            goto L_0x01db
        L_0x01d2:
            r17 = r5
            r18 = r7
            r21 = r12
        L_0x01d8:
            java.util.TimeZone r5 = TIMEZONE_UTC     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r3 = r5
        L_0x01db:
            r7 = r18
        L_0x01dd:
            java.util.GregorianCalendar r5 = new java.util.GregorianCalendar     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r5.<init>(r3)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r12 = 0
            r5.setLenient(r12)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r12 = 1
            r5.set(r12, r0)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            int r12 = r4 + -1
            r13 = 2
            r5.set(r13, r12)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r12 = 5
            r5.set(r12, r6)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r12 = 11
            r5.set(r12, r8)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r12 = 12
            r5.set(r12, r9)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r12 = 13
            r5.set(r12, r10)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r12 = 14
            r5.set(r12, r11)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            r2.setIndex(r7)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.util.Date r12 = r5.getTime()     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            return r12
        L_0x0210:
            r21 = r12
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            java.lang.String r5 = "No time zone indicator"
            r3.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
            throw r3     // Catch:{ IndexOutOfBoundsException -> 0x021e, NumberFormatException -> 0x021c, IllegalArgumentException -> 0x021a }
        L_0x021a:
            r0 = move-exception
            goto L_0x0223
        L_0x021c:
            r0 = move-exception
            goto L_0x0228
        L_0x021e:
            r0 = move-exception
            goto L_0x022d
        L_0x0220:
            r0 = move-exception
            r20 = r3
        L_0x0223:
            r3 = r0
            goto L_0x022f
        L_0x0225:
            r0 = move-exception
            r20 = r3
        L_0x0228:
            r3 = r0
            goto L_0x022e
        L_0x022a:
            r0 = move-exception
            r20 = r3
        L_0x022d:
            r3 = r0
        L_0x022e:
        L_0x022f:
            if (r1 != 0) goto L_0x0233
            r0 = 0
            goto L_0x024a
        L_0x0233:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r4 = 34
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r4)
            java.lang.String r0 = r0.toString()
        L_0x024a:
            java.lang.String r4 = r3.getMessage()
            if (r4 == 0) goto L_0x0256
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x0277
        L_0x0256:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "("
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.Class r6 = r3.getClass()
            java.lang.String r6 = r6.getName()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r6 = ")"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r4 = r5.toString()
        L_0x0277:
            java.text.ParseException r5 = new java.text.ParseException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Failed to parse date ["
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r7 = "]: "
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.StringBuilder r6 = r6.append(r4)
            java.lang.String r6 = r6.toString()
            int r7 = r23.getIndex()
            r5.<init>(r6, r7)
            r5.initCause(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static boolean checkOffset(String value, int offset, char expected) {
        return offset < value.length() && value.charAt(offset) == expected;
    }

    private static int parseInt(String value, int beginIndex, int endIndex) throws NumberFormatException {
        if (beginIndex < 0 || endIndex > value.length() || beginIndex > endIndex) {
            throw new NumberFormatException(value);
        }
        int digit = beginIndex;
        int result = 0;
        if (digit < endIndex) {
            int i = digit + 1;
            int digit2 = Character.digit(value.charAt(digit), 10);
            if (digit2 >= 0) {
                result = -digit2;
                digit = i;
            } else {
                throw new NumberFormatException("Invalid number: " + value.substring(beginIndex, endIndex));
            }
        }
        while (digit < endIndex) {
            int i2 = digit + 1;
            int digit3 = Character.digit(value.charAt(digit), 10);
            if (digit3 >= 0) {
                result = (result * 10) - digit3;
                digit = i2;
            } else {
                throw new NumberFormatException("Invalid number: " + value.substring(beginIndex, endIndex));
            }
        }
        return -result;
    }

    private static void padInt(StringBuilder buffer, int value, int length) {
        String strValue = Integer.toString(value);
        for (int i = length - strValue.length(); i > 0; i--) {
            buffer.append('0');
        }
        buffer.append(strValue);
    }

    private static int indexOfNonDigit(String string, int offset) {
        for (int i = offset; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c < '0' || c > '9') {
                return i;
            }
        }
        return string.length();
    }
}
