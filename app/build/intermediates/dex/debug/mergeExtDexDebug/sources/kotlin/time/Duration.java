package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@JvmInline
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b4\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\b@\u0018\u0000 ¥\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002¥\u0001B\u0014\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bN\u0010OJ\u001b\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bR\u0010SJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bV\u0010WJ\u001e\u0010T\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bV\u0010XJ\u001b\u0010T\u001a\u00020\u000f2\u0006\u0010Q\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\u001a\u0010[\u001a\u00020\\2\b\u0010Q\u001a\u0004\u0018\u00010]HÖ\u0003¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\tHÖ\u0001¢\u0006\u0004\ba\u0010\rJ\r\u0010b\u001a\u00020\\¢\u0006\u0004\bc\u0010dJ\u000f\u0010e\u001a\u00020\\H\u0002¢\u0006\u0004\bf\u0010dJ\u000f\u0010g\u001a\u00020\\H\u0002¢\u0006\u0004\bh\u0010dJ\r\u0010i\u001a\u00020\\¢\u0006\u0004\bj\u0010dJ\r\u0010k\u001a\u00020\\¢\u0006\u0004\bl\u0010dJ\r\u0010m\u001a\u00020\\¢\u0006\u0004\bn\u0010dJ\u001b\u0010o\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bp\u0010qJ\u001b\u0010r\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020\u0000H\u0002ø\u0001\u0000¢\u0006\u0004\bs\u0010qJ\u0017\u0010t\u001a\u00020\t2\u0006\u0010I\u001a\u00020\u000fH\u0002¢\u0006\u0004\bu\u0010vJ\u001e\u0010w\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u000fH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bx\u0010WJ\u001e\u0010w\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\tH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bx\u0010XJ£\u0001\u0010y\u001a\u0002Hz\"\u0004\b\u0000\u0010z2y\u0010{\u001au\u0012\u0013\u0012\u00110\t¢\u0006\f\b}\u0012\b\b~\u0012\u0004\b\b(\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u0002Hz0|H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0001\u0010y\u001a\u0002Hz\"\u0004\b\u0000\u0010z2e\u0010{\u001aa\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u0002Hz0\u0001H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0001\u0010\u0001Jy\u0010y\u001a\u0002Hz\"\u0004\b\u0000\u0010z2O\u0010{\u001aK\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u0002Hz0\u0001H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0001\u0010\u0001Jc\u0010y\u001a\u0002Hz\"\u0004\b\u0000\u0010z29\u0010{\u001a5\u0012\u0014\u0012\u00120\u0003¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0001\u0012\u0014\u0012\u00120\t¢\u0006\r\b}\u0012\t\b~\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u0002Hz0\u0001H\bø\u0001\u0002\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u000f2\f\u0010\u0001\u001a\u00070Dj\u0003`\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\t2\f\u0010\u0001\u001a\u00070Dj\u0003`\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00032\f\u0010\u0001\u001a\u00070Dj\u0003`\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0001\u0010\u0005J\u0011\u0010\u0001\u001a\u00020\u0003H\u0007¢\u0006\u0005\b\u0001\u0010\u0005J\u0013\u0010\u0001\u001a\u00030\u0001H\u0016¢\u0006\u0006\b \u0001\u0010\u0001J*\u0010\u0001\u001a\u00030\u00012\f\u0010\u0001\u001a\u00070Dj\u0003`\u00012\t\b\u0002\u0010¡\u0001\u001a\u00020\t¢\u0006\u0006\b \u0001\u0010¢\u0001J\u0018\u0010£\u0001\u001a\u00020\u0000H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b¤\u0001\u0010\u0005R\u0017\u0010\u0006\u001a\u00020\u00008Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\u0012R\u001a\u0010\u001c\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\u0012R\u001a\u0010\u001f\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\u0012R\u001a\u0010\"\u001a\u00020\u000f8FX\u0004¢\u0006\f\u0012\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\u0012R\u001a\u0010%\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b&\u0010\u000b\u001a\u0004\b'\u0010\u0005R\u001a\u0010(\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\u0005R\u001a\u0010+\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b,\u0010\u000b\u001a\u0004\b-\u0010\u0005R\u001a\u0010.\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b/\u0010\u000b\u001a\u0004\b0\u0010\u0005R\u001a\u00101\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\u0005R\u001a\u00104\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\u0005R\u001a\u00107\u001a\u00020\u00038FX\u0004¢\u0006\f\u0012\u0004\b8\u0010\u000b\u001a\u0004\b9\u0010\u0005R\u001a\u0010:\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b;\u0010\u000b\u001a\u0004\b<\u0010\rR\u001a\u0010=\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\b>\u0010\u000b\u001a\u0004\b?\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\t8@X\u0004¢\u0006\f\u0012\u0004\bA\u0010\u000b\u001a\u0004\bB\u0010\rR\u0014\u0010C\u001a\u00020D8BX\u0004¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0015\u0010G\u001a\u00020\t8Â\u0002X\u0004¢\u0006\u0006\u001a\u0004\bH\u0010\rR\u0014\u0010I\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010\u0005\u0001\u0002\u0001\u00020\u0003ø\u0001\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b20\u0001¨\u0006¦\u0001"}, d2 = {"Lkotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "absoluteValue", "getAbsoluteValue-UwyO8pc", "hoursComponent", "", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "(J)I", "inDays", "", "getInDays$annotations", "getInDays-impl", "(J)D", "inHours", "getInHours$annotations", "getInHours-impl", "inMicroseconds", "getInMicroseconds$annotations", "getInMicroseconds-impl", "inMilliseconds", "getInMilliseconds$annotations", "getInMilliseconds-impl", "inMinutes", "getInMinutes$annotations", "getInMinutes-impl", "inNanoseconds", "getInNanoseconds$annotations", "getInNanoseconds-impl", "inSeconds", "getInSeconds$annotations", "getInSeconds-impl", "inWholeDays", "getInWholeDays$annotations", "getInWholeDays-impl", "inWholeHours", "getInWholeHours$annotations", "getInWholeHours-impl", "inWholeMicroseconds", "getInWholeMicroseconds$annotations", "getInWholeMicroseconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds$annotations", "getInWholeMilliseconds-impl", "inWholeMinutes", "getInWholeMinutes$annotations", "getInWholeMinutes-impl", "inWholeNanoseconds", "getInWholeNanoseconds$annotations", "getInWholeNanoseconds-impl", "inWholeSeconds", "getInWholeSeconds$annotations", "getInWholeSeconds-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "storageUnit", "Ljava/util/concurrent/TimeUnit;", "getStorageUnit-impl", "(J)Ljava/util/concurrent/TimeUnit;", "unitDiscriminator", "getUnitDiscriminator-impl", "value", "getValue-impl", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "compareTo", "other", "compareTo-LRDsOJo", "(JJ)I", "div", "scale", "div-UwyO8pc", "(JD)J", "(JI)J", "div-LRDsOJo", "(JJ)D", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isFinite", "isFinite-impl", "(J)Z", "isInMillis", "isInMillis-impl", "isInNanos", "isInNanos-impl", "isInfinite", "isInfinite-impl", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "minus", "minus-LRDsOJo", "(JJ)J", "plus", "plus-LRDsOJo", "precision", "precision-impl", "(JD)I", "times", "times-UwyO8pc", "toComponents", "T", "action", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lkotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toDouble", "unit", "Lkotlin/time/DurationUnit;", "toDouble-impl", "(JLjava/util/concurrent/TimeUnit;)D", "toInt", "toInt-impl", "(JLjava/util/concurrent/TimeUnit;)I", "toIsoString", "", "toIsoString-impl", "(J)Ljava/lang/String;", "toLong", "toLong-impl", "(JLjava/util/concurrent/TimeUnit;)J", "toLongMilliseconds", "toLongMilliseconds-impl", "toLongNanoseconds", "toLongNanoseconds-impl", "toString", "toString-impl", "decimals", "(JLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "unaryMinus", "unaryMinus-UwyO8pc", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* compiled from: Duration.kt */
public final class Duration implements Comparable<Duration> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final long INFINITE = DurationKt.durationOfMillis(DurationKt.MAX_MILLIS);
    /* access modifiers changed from: private */
    public static final long NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);
    /* access modifiers changed from: private */
    public static final long ZERO = m1299constructorimpl(0);
    private final long rawValue;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Duration m1297boximpl(long j) {
        return new Duration(j);
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1303equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).m1354unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1304equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getHoursComponent$annotations() {
    }

    @Deprecated(message = "Use inWholeDays property instead or convert toDouble(DAYS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.DAYS)", imports = {}))
    public static /* synthetic */ void getInDays$annotations() {
    }

    @Deprecated(message = "Use inWholeHours property instead or convert toDouble(HOURS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.HOURS)", imports = {}))
    public static /* synthetic */ void getInHours$annotations() {
    }

    @Deprecated(message = "Use inWholeMicroseconds property instead or convert toDouble(MICROSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MICROSECONDS)", imports = {}))
    public static /* synthetic */ void getInMicroseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead or convert toDouble(MILLISECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MILLISECONDS)", imports = {}))
    public static /* synthetic */ void getInMilliseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeMinutes property instead or convert toDouble(MINUTES) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.MINUTES)", imports = {}))
    public static /* synthetic */ void getInMinutes$annotations() {
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead or convert toDouble(NANOSECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.NANOSECONDS)", imports = {}))
    public static /* synthetic */ void getInNanoseconds$annotations() {
    }

    @Deprecated(message = "Use inWholeSeconds property instead or convert toDouble(SECONDS) if a double value is required.", replaceWith = @ReplaceWith(expression = "toDouble(DurationUnit.SECONDS)", imports = {}))
    public static /* synthetic */ void getInSeconds$annotations() {
    }

    public static /* synthetic */ void getInWholeDays$annotations() {
    }

    public static /* synthetic */ void getInWholeHours$annotations() {
    }

    public static /* synthetic */ void getInWholeMicroseconds$annotations() {
    }

    public static /* synthetic */ void getInWholeMilliseconds$annotations() {
    }

    public static /* synthetic */ void getInWholeMinutes$annotations() {
    }

    public static /* synthetic */ void getInWholeNanoseconds$annotations() {
    }

    public static /* synthetic */ void getInWholeSeconds$annotations() {
    }

    public static /* synthetic */ void getMinutesComponent$annotations() {
    }

    public static /* synthetic */ void getNanosecondsComponent$annotations() {
    }

    public static /* synthetic */ void getSecondsComponent$annotations() {
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1327hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public int m1353compareToLRDsOJo(long j) {
        return m1298compareToLRDsOJo(this.rawValue, j);
    }

    public boolean equals(Object obj) {
        return m1303equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m1327hashCodeimpl(this.rawValue);
    }

    public String toString() {
        return m1349toStringimpl(this.rawValue);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m1354unboximpl() {
        return this.rawValue;
    }

    private /* synthetic */ Duration(long rawValue2) {
        this.rawValue = rawValue2;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1299constructorimpl(long rawValue2) {
        if (m1330isInNanosimpl(rawValue2)) {
            long r4 = m1326getValueimpl(rawValue2);
            if (-4611686018426999999L > r4 || DurationKt.MAX_NANOS < r4) {
                throw new AssertionError(m1326getValueimpl(rawValue2) + " ns is out of nanoseconds range");
            }
        } else {
            long r42 = m1326getValueimpl(rawValue2);
            if (-4611686018427387903L > r42 || DurationKt.MAX_MILLIS < r42) {
                throw new AssertionError(m1326getValueimpl(rawValue2) + " ms is out of milliseconds range");
            }
            long r43 = m1326getValueimpl(rawValue2);
            if (-4611686018426L <= r43 && 4611686018426L >= r43) {
                throw new AssertionError(m1326getValueimpl(rawValue2) + " ms is denormalized");
            }
        }
        return rawValue2;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m1353compareToLRDsOJo(((Duration) obj).m1354unboximpl());
    }

    /* renamed from: getValue-impl  reason: not valid java name */
    private static final long m1326getValueimpl(long $this) {
        return $this >> 1;
    }

    /* renamed from: getUnitDiscriminator-impl  reason: not valid java name */
    private static final int m1325getUnitDiscriminatorimpl(long $this) {
        return ((int) $this) & 1;
    }

    /* renamed from: isInNanos-impl  reason: not valid java name */
    private static final boolean m1330isInNanosimpl(long $this) {
        if ((((int) $this) & 1) == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: isInMillis-impl  reason: not valid java name */
    private static final boolean m1329isInMillisimpl(long $this) {
        if ((((int) $this) & 1) == 1) {
            return true;
        }
        return false;
    }

    /* renamed from: getStorageUnit-impl  reason: not valid java name */
    private static final TimeUnit m1324getStorageUnitimpl(long $this) {
        return m1330isInNanosimpl($this) ? TimeUnit.NANOSECONDS : TimeUnit.MILLISECONDS;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\n\u0010\u0012\u001a\u00060\u0010j\u0002`\u0011J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0017J\u001d\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0019J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0015J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0019J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0015J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0017J\u001d\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0019J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0015J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0017J\u001d\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0019J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0015J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0017J\u001d\u0010 \u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0019J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0015J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0017J\u001d\u0010\"\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0019J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u0015J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0016H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u0017J\u001d\u0010$\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010\u0019R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006&"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "()V", "INFINITE", "Lkotlin/time/Duration;", "getINFINITE-UwyO8pc", "()J", "J", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "ZERO", "getZERO-UwyO8pc", "convert", "", "value", "sourceUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "targetUnit", "days", "days-UwyO8pc", "(D)J", "", "(I)J", "", "(J)J", "hours", "hours-UwyO8pc", "microseconds", "microseconds-UwyO8pc", "milliseconds", "milliseconds-UwyO8pc", "minutes", "minutes-UwyO8pc", "nanoseconds", "nanoseconds-UwyO8pc", "seconds", "seconds-UwyO8pc", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* compiled from: Duration.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        /* renamed from: getZERO-UwyO8pc  reason: not valid java name */
        public final long m1360getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        /* renamed from: getINFINITE-UwyO8pc  reason: not valid java name */
        public final long m1358getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        /* renamed from: getNEG_INFINITE-UwyO8pc$kotlin_stdlib  reason: not valid java name */
        public final long m1359getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        public final double convert(double value, TimeUnit sourceUnit, TimeUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m1374nanosecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.NANOSECONDS);
        }

        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m1375nanosecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.NANOSECONDS);
        }

        /* renamed from: nanoseconds-UwyO8pc  reason: not valid java name */
        public final long m1373nanosecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.NANOSECONDS);
        }

        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m1365microsecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.MICROSECONDS);
        }

        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m1366microsecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.MICROSECONDS);
        }

        /* renamed from: microseconds-UwyO8pc  reason: not valid java name */
        public final long m1364microsecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.MICROSECONDS);
        }

        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m1368millisecondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.MILLISECONDS);
        }

        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m1369millisecondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.MILLISECONDS);
        }

        /* renamed from: milliseconds-UwyO8pc  reason: not valid java name */
        public final long m1367millisecondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.MILLISECONDS);
        }

        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m1377secondsUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.SECONDS);
        }

        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m1378secondsUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.SECONDS);
        }

        /* renamed from: seconds-UwyO8pc  reason: not valid java name */
        public final long m1376secondsUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.SECONDS);
        }

        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m1371minutesUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.MINUTES);
        }

        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m1372minutesUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.MINUTES);
        }

        /* renamed from: minutes-UwyO8pc  reason: not valid java name */
        public final long m1370minutesUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.MINUTES);
        }

        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m1362hoursUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.HOURS);
        }

        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m1363hoursUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.HOURS);
        }

        /* renamed from: hours-UwyO8pc  reason: not valid java name */
        public final long m1361hoursUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.HOURS);
        }

        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m1356daysUwyO8pc(int value) {
            return DurationKt.toDuration(value, TimeUnit.DAYS);
        }

        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m1357daysUwyO8pc(long value) {
            return DurationKt.toDuration(value, TimeUnit.DAYS);
        }

        /* renamed from: days-UwyO8pc  reason: not valid java name */
        public final long m1355daysUwyO8pc(double value) {
            return DurationKt.toDuration(value, TimeUnit.DAYS);
        }
    }

    /* renamed from: unaryMinus-UwyO8pc  reason: not valid java name */
    public static final long m1352unaryMinusUwyO8pc(long $this) {
        return DurationKt.durationOf(-m1326getValueimpl($this), ((int) $this) & 1);
    }

    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public static final long m1335plusLRDsOJo(long $this, long other) {
        if (m1331isInfiniteimpl($this)) {
            if (m1328isFiniteimpl(other) || ($this ^ other) >= 0) {
                return $this;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        } else if (m1331isInfiniteimpl(other)) {
            return other;
        } else {
            if ((((int) $this) & 1) == (((int) other) & 1)) {
                long result = m1326getValueimpl($this) + m1326getValueimpl(other);
                if (m1330isInNanosimpl($this)) {
                    return DurationKt.durationOfNanosNormalized(result);
                }
                return DurationKt.durationOfMillisNormalized(result);
            } else if (m1329isInMillisimpl($this)) {
                return m1296addValuesMixedRangesUwyO8pc($this, m1326getValueimpl($this), m1326getValueimpl(other));
            } else {
                return m1296addValuesMixedRangesUwyO8pc($this, m1326getValueimpl(other), m1326getValueimpl($this));
            }
        }
    }

    /* renamed from: addValuesMixedRanges-UwyO8pc  reason: not valid java name */
    private static final long m1296addValuesMixedRangesUwyO8pc(long $this, long thisMillis, long otherNanos) {
        long otherMillis = DurationKt.nanosToMillis(otherNanos);
        long resultMillis = thisMillis + otherMillis;
        if (-4611686018426L > resultMillis || 4611686018426L < resultMillis) {
            return DurationKt.durationOfMillis(RangesKt.coerceIn(resultMillis, -4611686018427387903L, (long) DurationKt.MAX_MILLIS));
        }
        return DurationKt.durationOfNanos(DurationKt.millisToNanos(resultMillis) + (otherNanos - DurationKt.millisToNanos(otherMillis)));
    }

    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public static final long m1334minusLRDsOJo(long $this, long other) {
        return m1335plusLRDsOJo($this, m1352unaryMinusUwyO8pc(other));
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m1338timesUwyO8pc(long $this, int scale) {
        int i = scale;
        if (m1331isInfiniteimpl($this)) {
            if (i == 0) {
                throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
            } else if (i > 0) {
                return $this;
            } else {
                return m1352unaryMinusUwyO8pc($this);
            }
        } else if (i == 0) {
            return ZERO;
        } else {
            long value = m1326getValueimpl($this);
            long result = ((long) i) * value;
            if (m1330isInNanosimpl($this)) {
                if (-2147483647L <= value && 2147483647L >= value) {
                    return DurationKt.durationOfNanos(result);
                }
                if (result / ((long) i) == value) {
                    return DurationKt.durationOfNanosNormalized(result);
                }
                long millis = DurationKt.nanosToMillis(value);
                long resultMillis = ((long) i) * millis;
                long totalMillis = DurationKt.nanosToMillis(((long) i) * (value - DurationKt.millisToNanos(millis))) + resultMillis;
                if (resultMillis / ((long) i) != millis || (totalMillis ^ resultMillis) < 0) {
                    return MathKt.getSign(value) * MathKt.getSign(scale) > 0 ? INFINITE : NEG_INFINITE;
                }
                long j = millis;
                return DurationKt.durationOfMillis(RangesKt.coerceIn(totalMillis, (ClosedRange<Long>) new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
            } else if (result / ((long) i) == value) {
                return DurationKt.durationOfMillis(RangesKt.coerceIn(result, (ClosedRange<Long>) new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
            } else {
                return MathKt.getSign(value) * MathKt.getSign(scale) > 0 ? INFINITE : NEG_INFINITE;
            }
        }
    }

    /* renamed from: times-UwyO8pc  reason: not valid java name */
    public static final long m1337timesUwyO8pc(long $this, double scale) {
        int intScale = MathKt.roundToInt(scale);
        if (((double) intScale) == scale) {
            return m1338timesUwyO8pc($this, intScale);
        }
        TimeUnit unit = m1324getStorageUnitimpl($this);
        return DurationKt.toDuration(m1343toDoubleimpl($this, unit) * scale, unit);
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m1302divUwyO8pc(long $this, int scale) {
        if (scale == 0) {
            if (m1333isPositiveimpl($this)) {
                return INFINITE;
            }
            if (m1332isNegativeimpl($this)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        } else if (m1330isInNanosimpl($this)) {
            return DurationKt.durationOfNanos(m1326getValueimpl($this) / ((long) scale));
        } else {
            if (m1331isInfiniteimpl($this)) {
                return m1338timesUwyO8pc($this, MathKt.getSign(scale));
            }
            long result = m1326getValueimpl($this) / ((long) scale);
            if (-4611686018426L > result || 4611686018426L < result) {
                return DurationKt.durationOfMillis(result);
            }
            return DurationKt.durationOfNanos(DurationKt.millisToNanos(result) + (DurationKt.millisToNanos(m1326getValueimpl($this) - (((long) scale) * result)) / ((long) scale)));
        }
    }

    /* renamed from: div-UwyO8pc  reason: not valid java name */
    public static final long m1301divUwyO8pc(long $this, double scale) {
        int intScale = MathKt.roundToInt(scale);
        if (((double) intScale) == scale && intScale != 0) {
            return m1302divUwyO8pc($this, intScale);
        }
        TimeUnit unit = m1324getStorageUnitimpl($this);
        return DurationKt.toDuration(m1343toDoubleimpl($this, unit) / scale, unit);
    }

    /* renamed from: div-LRDsOJo  reason: not valid java name */
    public static final double m1300divLRDsOJo(long $this, long other) {
        TimeUnit coarserUnit = (TimeUnit) ComparisonsKt.maxOf(m1324getStorageUnitimpl($this), m1324getStorageUnitimpl(other));
        return m1343toDoubleimpl($this, coarserUnit) / m1343toDoubleimpl(other, coarserUnit);
    }

    /* renamed from: isNegative-impl  reason: not valid java name */
    public static final boolean m1332isNegativeimpl(long $this) {
        return $this < 0;
    }

    /* renamed from: isPositive-impl  reason: not valid java name */
    public static final boolean m1333isPositiveimpl(long $this) {
        return $this > 0;
    }

    /* renamed from: isInfinite-impl  reason: not valid java name */
    public static final boolean m1331isInfiniteimpl(long $this) {
        return $this == INFINITE || $this == NEG_INFINITE;
    }

    /* renamed from: isFinite-impl  reason: not valid java name */
    public static final boolean m1328isFiniteimpl(long $this) {
        return !m1331isInfiniteimpl($this);
    }

    /* renamed from: getAbsoluteValue-UwyO8pc  reason: not valid java name */
    public static final long m1305getAbsoluteValueUwyO8pc(long $this) {
        return m1332isNegativeimpl($this) ? m1352unaryMinusUwyO8pc($this) : $this;
    }

    /* renamed from: compareTo-LRDsOJo  reason: not valid java name */
    public static int m1298compareToLRDsOJo(long $this, long other) {
        long compareBits = $this ^ other;
        if (compareBits < 0 || (((int) compareBits) & 1) == 0) {
            return ($this > other ? 1 : ($this == other ? 0 : -1));
        }
        int r = (((int) $this) & 1) - (((int) other) & 1);
        return m1332isNegativeimpl($this) ? -r : r;
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1342toComponentsimpl(long $this, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf(m1344toIntimpl($this, TimeUnit.DAYS)), Integer.valueOf(m1306getHoursComponentimpl($this)), Integer.valueOf(m1321getMinutesComponentimpl($this)), Integer.valueOf(m1323getSecondsComponentimpl($this)), Integer.valueOf(m1322getNanosecondsComponentimpl($this)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1341toComponentsimpl(long $this, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf(m1344toIntimpl($this, TimeUnit.HOURS)), Integer.valueOf(m1321getMinutesComponentimpl($this)), Integer.valueOf(m1323getSecondsComponentimpl($this)), Integer.valueOf(m1322getNanosecondsComponentimpl($this)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1340toComponentsimpl(long $this, Function3<? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Integer.valueOf(m1344toIntimpl($this, TimeUnit.MINUTES)), Integer.valueOf(m1323getSecondsComponentimpl($this)), Integer.valueOf(m1322getNanosecondsComponentimpl($this)));
    }

    /* renamed from: toComponents-impl  reason: not valid java name */
    public static final <T> T m1339toComponentsimpl(long $this, Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(m1320getInWholeSecondsimpl($this)), Integer.valueOf(m1322getNanosecondsComponentimpl($this)));
    }

    /* renamed from: getHoursComponent-impl  reason: not valid java name */
    public static final int m1306getHoursComponentimpl(long $this) {
        if (m1331isInfiniteimpl($this)) {
            return 0;
        }
        return (int) (m1315getInWholeHoursimpl($this) % ((long) 24));
    }

    /* renamed from: getMinutesComponent-impl  reason: not valid java name */
    public static final int m1321getMinutesComponentimpl(long $this) {
        if (m1331isInfiniteimpl($this)) {
            return 0;
        }
        return (int) (m1318getInWholeMinutesimpl($this) % ((long) 60));
    }

    /* renamed from: getSecondsComponent-impl  reason: not valid java name */
    public static final int m1323getSecondsComponentimpl(long $this) {
        if (m1331isInfiniteimpl($this)) {
            return 0;
        }
        return (int) (m1320getInWholeSecondsimpl($this) % ((long) 60));
    }

    /* renamed from: getNanosecondsComponent-impl  reason: not valid java name */
    public static final int m1322getNanosecondsComponentimpl(long $this) {
        if (m1331isInfiniteimpl($this)) {
            return 0;
        }
        if (m1329isInMillisimpl($this)) {
            return (int) DurationKt.millisToNanos(m1326getValueimpl($this) % ((long) 1000));
        }
        return (int) (m1326getValueimpl($this) % ((long) 1000000000));
    }

    /* renamed from: toDouble-impl  reason: not valid java name */
    public static final double m1343toDoubleimpl(long $this, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if ($this == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if ($this == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt.convertDurationUnit((double) m1326getValueimpl($this), m1324getStorageUnitimpl($this), unit);
    }

    /* renamed from: toLong-impl  reason: not valid java name */
    public static final long m1346toLongimpl(long $this, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if ($this == INFINITE) {
            return LongCompanionObject.MAX_VALUE;
        }
        if ($this == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt.convertDurationUnit(m1326getValueimpl($this), m1324getStorageUnitimpl($this), unit);
    }

    /* renamed from: toInt-impl  reason: not valid java name */
    public static final int m1344toIntimpl(long $this, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) RangesKt.coerceIn(m1346toLongimpl($this, unit), (long) Integer.MIN_VALUE, (long) Integer.MAX_VALUE);
    }

    /* renamed from: getInDays-impl  reason: not valid java name */
    public static final double m1307getInDaysimpl(long $this) {
        return m1343toDoubleimpl($this, TimeUnit.DAYS);
    }

    /* renamed from: getInHours-impl  reason: not valid java name */
    public static final double m1308getInHoursimpl(long $this) {
        return m1343toDoubleimpl($this, TimeUnit.HOURS);
    }

    /* renamed from: getInMinutes-impl  reason: not valid java name */
    public static final double m1311getInMinutesimpl(long $this) {
        return m1343toDoubleimpl($this, TimeUnit.MINUTES);
    }

    /* renamed from: getInSeconds-impl  reason: not valid java name */
    public static final double m1313getInSecondsimpl(long $this) {
        return m1343toDoubleimpl($this, TimeUnit.SECONDS);
    }

    /* renamed from: getInMilliseconds-impl  reason: not valid java name */
    public static final double m1310getInMillisecondsimpl(long $this) {
        return m1343toDoubleimpl($this, TimeUnit.MILLISECONDS);
    }

    /* renamed from: getInMicroseconds-impl  reason: not valid java name */
    public static final double m1309getInMicrosecondsimpl(long $this) {
        return m1343toDoubleimpl($this, TimeUnit.MICROSECONDS);
    }

    /* renamed from: getInNanoseconds-impl  reason: not valid java name */
    public static final double m1312getInNanosecondsimpl(long $this) {
        return m1343toDoubleimpl($this, TimeUnit.NANOSECONDS);
    }

    /* renamed from: getInWholeDays-impl  reason: not valid java name */
    public static final long m1314getInWholeDaysimpl(long $this) {
        return m1346toLongimpl($this, TimeUnit.DAYS);
    }

    /* renamed from: getInWholeHours-impl  reason: not valid java name */
    public static final long m1315getInWholeHoursimpl(long $this) {
        return m1346toLongimpl($this, TimeUnit.HOURS);
    }

    /* renamed from: getInWholeMinutes-impl  reason: not valid java name */
    public static final long m1318getInWholeMinutesimpl(long $this) {
        return m1346toLongimpl($this, TimeUnit.MINUTES);
    }

    /* renamed from: getInWholeSeconds-impl  reason: not valid java name */
    public static final long m1320getInWholeSecondsimpl(long $this) {
        return m1346toLongimpl($this, TimeUnit.SECONDS);
    }

    /* renamed from: getInWholeMilliseconds-impl  reason: not valid java name */
    public static final long m1317getInWholeMillisecondsimpl(long $this) {
        return (!m1329isInMillisimpl($this) || !m1328isFiniteimpl($this)) ? m1346toLongimpl($this, TimeUnit.MILLISECONDS) : m1326getValueimpl($this);
    }

    /* renamed from: getInWholeMicroseconds-impl  reason: not valid java name */
    public static final long m1316getInWholeMicrosecondsimpl(long $this) {
        return m1346toLongimpl($this, TimeUnit.MICROSECONDS);
    }

    /* renamed from: getInWholeNanoseconds-impl  reason: not valid java name */
    public static final long m1319getInWholeNanosecondsimpl(long $this) {
        long value = m1326getValueimpl($this);
        if (m1330isInNanosimpl($this)) {
            return value;
        }
        if (value > 9223372036854L) {
            return LongCompanionObject.MAX_VALUE;
        }
        if (value < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.millisToNanos(value);
    }

    @Deprecated(message = "Use inWholeNanoseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeNanoseconds", imports = {}))
    /* renamed from: toLongNanoseconds-impl  reason: not valid java name */
    public static final long m1348toLongNanosecondsimpl(long $this) {
        return m1319getInWholeNanosecondsimpl($this);
    }

    @Deprecated(message = "Use inWholeMilliseconds property instead.", replaceWith = @ReplaceWith(expression = "this.inWholeMilliseconds", imports = {}))
    /* renamed from: toLongMilliseconds-impl  reason: not valid java name */
    public static final long m1347toLongMillisecondsimpl(long $this) {
        return m1317getInWholeMillisecondsimpl($this);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1349toStringimpl(long $this) {
        TimeUnit unit;
        String str;
        if ($this == 0) {
            return "0s";
        }
        if ($this == INFINITE) {
            return "Infinity";
        }
        if ($this == NEG_INFINITE) {
            return "-Infinity";
        }
        double absNs = m1343toDoubleimpl(m1305getAbsoluteValueUwyO8pc($this), TimeUnit.NANOSECONDS);
        boolean scientific = false;
        int maxDecimals = 0;
        if (absNs < 1.0E-6d) {
            unit = TimeUnit.SECONDS;
            TimeUnit timeUnit = unit;
            scientific = true;
        } else if (absNs < ((double) 1)) {
            unit = TimeUnit.NANOSECONDS;
            TimeUnit timeUnit2 = unit;
            maxDecimals = 7;
        } else if (absNs < 1000.0d) {
            unit = TimeUnit.NANOSECONDS;
        } else if (absNs < 1000000.0d) {
            unit = TimeUnit.MICROSECONDS;
        } else if (absNs < 1.0E9d) {
            unit = TimeUnit.MILLISECONDS;
        } else if (absNs < 1.0E12d) {
            unit = TimeUnit.SECONDS;
        } else if (absNs < 6.0E13d) {
            unit = TimeUnit.MINUTES;
        } else if (absNs < 3.6E15d) {
            unit = TimeUnit.HOURS;
        } else if (absNs < 8.64E20d) {
            unit = TimeUnit.DAYS;
        } else {
            unit = TimeUnit.DAYS;
            TimeUnit timeUnit3 = unit;
            scientific = true;
        }
        double value = m1343toDoubleimpl($this, unit);
        StringBuilder sb = new StringBuilder();
        if (scientific) {
            str = FormatToDecimalsKt.formatScientific(value);
        } else if (maxDecimals > 0) {
            str = FormatToDecimalsKt.formatUpToDecimals(value, maxDecimals);
        } else {
            str = FormatToDecimalsKt.formatToExactDecimals(value, m1336precisionimpl($this, Math.abs(value)));
        }
        return sb.append(str).append(DurationUnitKt.shortName(unit)).toString();
    }

    /* renamed from: precision-impl  reason: not valid java name */
    private static final int m1336precisionimpl(long $this, double value) {
        if (value < ((double) 1)) {
            return 3;
        }
        if (value < ((double) 10)) {
            return 2;
        }
        if (value < ((double) 100)) {
            return 1;
        }
        return 0;
    }

    /* renamed from: toString-impl$default  reason: not valid java name */
    public static /* synthetic */ String m1351toStringimpl$default(long j, TimeUnit timeUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m1350toStringimpl(j, timeUnit, i);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static final String m1350toStringimpl(long $this, TimeUnit unit, int decimals) {
        String str;
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (decimals >= 0) {
            double number = m1343toDoubleimpl($this, unit);
            if (Double.isInfinite(number)) {
                return String.valueOf(number);
            }
            StringBuilder sb = new StringBuilder();
            if (Math.abs(number) < 1.0E14d) {
                str = FormatToDecimalsKt.formatToExactDecimals(number, RangesKt.coerceAtMost(decimals, 12));
            } else {
                str = FormatToDecimalsKt.formatScientific(number);
            }
            return sb.append(str).append(DurationUnitKt.shortName(unit)).toString();
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + decimals).toString());
    }

    /* renamed from: toIsoString-impl  reason: not valid java name */
    public static final String m1345toIsoStringimpl(long $this) {
        StringBuilder sb = new StringBuilder();
        StringBuilder $this$buildString = sb;
        if (m1332isNegativeimpl($this)) {
            $this$buildString.append('-');
        }
        $this$buildString.append("PT");
        long $this$iv = m1305getAbsoluteValueUwyO8pc($this);
        int hours = m1344toIntimpl($this$iv, TimeUnit.HOURS);
        int minutes = m1321getMinutesComponentimpl($this$iv);
        int seconds = m1323getSecondsComponentimpl($this$iv);
        int nanoseconds = m1322getNanosecondsComponentimpl($this$iv);
        boolean hasMinutes = true;
        boolean hasHours = hours != 0;
        boolean hasSeconds = (seconds == 0 && nanoseconds == 0) ? false : true;
        if (minutes == 0 && (!hasSeconds || !hasHours)) {
            hasMinutes = false;
        }
        if (hasHours) {
            $this$buildString.append(hours).append('H');
        }
        if (hasMinutes) {
            $this$buildString.append(minutes).append('M');
        }
        if (hasSeconds || (!hasHours && !hasMinutes)) {
            $this$buildString.append(seconds);
            if (nanoseconds != 0) {
                $this$buildString.append('.');
                String nss = StringsKt.padStart(String.valueOf(nanoseconds), 9, '0');
                if (nanoseconds % DurationKt.NANOS_IN_MILLIS == 0) {
                    long j = $this$iv;
                    Intrinsics.checkNotNullExpressionValue($this$buildString.append(nss, 0, 3), "this.append(value, startIndex, endIndex)");
                } else {
                    if (nanoseconds % 1000 == 0) {
                        Intrinsics.checkNotNullExpressionValue($this$buildString.append(nss, 0, 6), "this.append(value, startIndex, endIndex)");
                    } else {
                        $this$buildString.append(nss);
                    }
                }
            } else {
                long j2 = $this$iv;
            }
            $this$buildString.append('S');
        } else {
            long j3 = $this$iv;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
