package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0001H\n\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0001H\b\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\f\u001a\u0015\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\f\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n\u001a\r\u0010\u0010\u001a\u00020\u0011*\u00020\u0001H\b\u001a!\u0010\u0010\u001a\u00020\u0011*\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u0014H\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\rH\b\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0016H\b\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0001H\n\u001a\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\f¨\u0006\u0019"}, d2 = {"and", "Ljava/math/BigInteger;", "other", "dec", "div", "inc", "inv", "minus", "or", "plus", "rem", "shl", "n", "", "shr", "times", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "toBigInteger", "", "unaryMinus", "xor", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/NumbersKt")
/* compiled from: BigIntegers.kt */
class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    private static final BigInteger plus(BigInteger $this$plus, BigInteger other) {
        Intrinsics.checkNotNullParameter($this$plus, "$this$plus");
        BigInteger add = $this$plus.add(other);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(other)");
        return add;
    }

    private static final BigInteger minus(BigInteger $this$minus, BigInteger other) {
        Intrinsics.checkNotNullParameter($this$minus, "$this$minus");
        BigInteger subtract = $this$minus.subtract(other);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(other)");
        return subtract;
    }

    private static final BigInteger times(BigInteger $this$times, BigInteger other) {
        Intrinsics.checkNotNullParameter($this$times, "$this$times");
        BigInteger multiply = $this$times.multiply(other);
        Intrinsics.checkNotNullExpressionValue(multiply, "this.multiply(other)");
        return multiply;
    }

    private static final BigInteger div(BigInteger $this$div, BigInteger other) {
        Intrinsics.checkNotNullParameter($this$div, "$this$div");
        BigInteger divide = $this$div.divide(other);
        Intrinsics.checkNotNullExpressionValue(divide, "this.divide(other)");
        return divide;
    }

    private static final BigInteger rem(BigInteger $this$rem, BigInteger other) {
        Intrinsics.checkNotNullParameter($this$rem, "$this$rem");
        BigInteger remainder = $this$rem.remainder(other);
        Intrinsics.checkNotNullExpressionValue(remainder, "this.remainder(other)");
        return remainder;
    }

    private static final BigInteger unaryMinus(BigInteger $this$unaryMinus) {
        Intrinsics.checkNotNullParameter($this$unaryMinus, "$this$unaryMinus");
        BigInteger negate = $this$unaryMinus.negate();
        Intrinsics.checkNotNullExpressionValue(negate, "this.negate()");
        return negate;
    }

    private static final BigInteger inc(BigInteger $this$inc) {
        Intrinsics.checkNotNullParameter($this$inc, "$this$inc");
        BigInteger add = $this$inc.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(add, "this.add(BigInteger.ONE)");
        return add;
    }

    private static final BigInteger dec(BigInteger $this$dec) {
        Intrinsics.checkNotNullParameter($this$dec, "$this$dec");
        BigInteger subtract = $this$dec.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(subtract, "this.subtract(BigInteger.ONE)");
        return subtract;
    }

    private static final BigInteger inv(BigInteger $this$inv) {
        BigInteger not = $this$inv.not();
        Intrinsics.checkNotNullExpressionValue(not, "this.not()");
        return not;
    }

    private static final BigInteger and(BigInteger $this$and, BigInteger other) {
        BigInteger and = $this$and.and(other);
        Intrinsics.checkNotNullExpressionValue(and, "this.and(other)");
        return and;
    }

    private static final BigInteger or(BigInteger $this$or, BigInteger other) {
        BigInteger or = $this$or.or(other);
        Intrinsics.checkNotNullExpressionValue(or, "this.or(other)");
        return or;
    }

    private static final BigInteger xor(BigInteger $this$xor, BigInteger other) {
        BigInteger xor = $this$xor.xor(other);
        Intrinsics.checkNotNullExpressionValue(xor, "this.xor(other)");
        return xor;
    }

    private static final BigInteger shl(BigInteger $this$shl, int n) {
        BigInteger shiftLeft = $this$shl.shiftLeft(n);
        Intrinsics.checkNotNullExpressionValue(shiftLeft, "this.shiftLeft(n)");
        return shiftLeft;
    }

    private static final BigInteger shr(BigInteger $this$shr, int n) {
        BigInteger shiftRight = $this$shr.shiftRight(n);
        Intrinsics.checkNotNullExpressionValue(shiftRight, "this.shiftRight(n)");
        return shiftRight;
    }

    private static final BigInteger toBigInteger(int $this$toBigInteger) {
        BigInteger valueOf = BigInteger.valueOf((long) $this$toBigInteger);
        Intrinsics.checkNotNullExpressionValue(valueOf, "BigInteger.valueOf(this.toLong())");
        return valueOf;
    }

    private static final BigInteger toBigInteger(long $this$toBigInteger) {
        BigInteger valueOf = BigInteger.valueOf($this$toBigInteger);
        Intrinsics.checkNotNullExpressionValue(valueOf, "BigInteger.valueOf(this)");
        return valueOf;
    }

    private static final BigDecimal toBigDecimal(BigInteger $this$toBigDecimal) {
        return new BigDecimal($this$toBigDecimal);
    }

    static /* synthetic */ BigDecimal toBigDecimal$default(BigInteger $this$toBigDecimal, int scale, MathContext mathContext, int i, Object obj) {
        if ((i & 1) != 0) {
            scale = 0;
        }
        if ((i & 2) != 0) {
            MathContext mathContext2 = MathContext.UNLIMITED;
            Intrinsics.checkNotNullExpressionValue(mathContext2, "MathContext.UNLIMITED");
            mathContext = mathContext2;
        }
        return new BigDecimal($this$toBigDecimal, scale, mathContext);
    }

    private static final BigDecimal toBigDecimal(BigInteger $this$toBigDecimal, int scale, MathContext mathContext) {
        return new BigDecimal($this$toBigDecimal, scale, mathContext);
    }
}
