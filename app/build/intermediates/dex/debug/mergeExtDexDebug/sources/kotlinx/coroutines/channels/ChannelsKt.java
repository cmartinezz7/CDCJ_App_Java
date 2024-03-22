package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(bv = {1, 0, 3}, d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt"}, k = 4, mv = {1, 1, 13})
public final class ChannelsKt {
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    public static final <E> Object all(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.all($receiver, predicate, continuation);
    }

    private static final Object all$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.all($receiver, predicate, continuation);
    }

    public static final <E> Object any(ReceiveChannel<? extends E> $receiver, Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.any($receiver, continuation);
    }

    public static final <E> Object any(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.any($receiver, predicate, continuation);
    }

    private static final Object any$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.any($receiver, predicate, continuation);
    }

    public static final <E, K, V> Object associate(ReceiveChannel<? extends E> $receiver, Function1<? super E, ? extends Pair<? extends K, ? extends V>> transform, Continuation<? super Map<K, ? extends V>> continuation) {
        return ChannelsKt__Channels_commonKt.associate($receiver, transform, continuation);
    }

    private static final Object associate$$forInline(ReceiveChannel $receiver, Function1 transform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.associate($receiver, transform, continuation);
    }

    public static final <E, K> Object associateBy(ReceiveChannel<? extends E> $receiver, Function1<? super E, ? extends K> keySelector, Continuation<? super Map<K, ? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.associateBy($receiver, keySelector, continuation);
    }

    public static final <E, K, V> Object associateBy(ReceiveChannel<? extends E> $receiver, Function1<? super E, ? extends K> keySelector, Function1<? super E, ? extends V> valueTransform, Continuation<? super Map<K, ? extends V>> continuation) {
        return ChannelsKt__Channels_commonKt.associateBy($receiver, keySelector, valueTransform, continuation);
    }

    private static final Object associateBy$$forInline(ReceiveChannel $receiver, Function1 keySelector, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.associateBy($receiver, keySelector, continuation);
    }

    private static final Object associateBy$$forInline(ReceiveChannel $receiver, Function1 keySelector, Function1 valueTransform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.associateBy($receiver, keySelector, valueTransform, continuation);
    }

    public static final <E, K, M extends Map<? super K, ? super E>> Object associateByTo(ReceiveChannel<? extends E> $receiver, M destination, Function1<? super E, ? extends K> keySelector, Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.associateByTo($receiver, destination, keySelector, continuation);
    }

    public static final <E, K, V, M extends Map<? super K, ? super V>> Object associateByTo(ReceiveChannel<? extends E> $receiver, M destination, Function1<? super E, ? extends K> keySelector, Function1<? super E, ? extends V> valueTransform, Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.associateByTo($receiver, destination, keySelector, valueTransform, continuation);
    }

    private static final Object associateByTo$$forInline(ReceiveChannel $receiver, Map destination, Function1 keySelector, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.associateByTo($receiver, destination, keySelector, continuation);
    }

    private static final Object associateByTo$$forInline(ReceiveChannel $receiver, Map destination, Function1 keySelector, Function1 valueTransform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.associateByTo($receiver, destination, keySelector, valueTransform, continuation);
    }

    public static final <E, K, V, M extends Map<? super K, ? super V>> Object associateTo(ReceiveChannel<? extends E> $receiver, M destination, Function1<? super E, ? extends Pair<? extends K, ? extends V>> transform, Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.associateTo($receiver, destination, transform, continuation);
    }

    private static final Object associateTo$$forInline(ReceiveChannel $receiver, Map destination, Function1 transform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.associateTo($receiver, destination, transform, continuation);
    }

    public static final <E, R> R consume(BroadcastChannel<E> $receiver, Function1<? super ReceiveChannel<? extends E>, ? extends R> block) {
        return ChannelsKt__Channels_commonKt.consume($receiver, block);
    }

    public static final <E, R> R consume(ReceiveChannel<? extends E> $receiver, Function1<? super ReceiveChannel<? extends E>, ? extends R> block) {
        return ChannelsKt__Channels_commonKt.consume($receiver, block);
    }

    public static final <E> Object consumeEach(BroadcastChannel<E> $receiver, Function1<? super E, Unit> action, Continuation<? super Unit> continuation) {
        return ChannelsKt__Channels_commonKt.consumeEach($receiver, action, continuation);
    }

    public static final <E> Object consumeEach(ReceiveChannel<? extends E> $receiver, Function1<? super E, Unit> action, Continuation<? super Unit> continuation) {
        return ChannelsKt__Channels_commonKt.consumeEach($receiver, action, continuation);
    }

    private static final Object consumeEach$$forInline(BroadcastChannel $receiver, Function1 action, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.consumeEach($receiver, action, (Continuation<? super Unit>) continuation);
    }

    private static final Object consumeEach$$forInline(ReceiveChannel $receiver, Function1 action, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.consumeEach($receiver, action, (Continuation<? super Unit>) continuation);
    }

    public static final <E> Object consumeEachIndexed(ReceiveChannel<? extends E> $receiver, Function1<? super IndexedValue<? extends E>, Unit> action, Continuation<? super Unit> continuation) {
        return ChannelsKt__Channels_commonKt.consumeEachIndexed($receiver, action, continuation);
    }

    private static final Object consumeEachIndexed$$forInline(ReceiveChannel $receiver, Function1 action, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.consumeEachIndexed($receiver, action, continuation);
    }

    public static final Function1<Throwable, Unit> consumes(ReceiveChannel<?> $receiver) {
        return ChannelsKt__Channels_commonKt.consumes($receiver);
    }

    public static final Function1<Throwable, Unit> consumesAll(ReceiveChannel<?>... channels) {
        return ChannelsKt__Channels_commonKt.consumesAll(channels);
    }

    public static final <E> Object count(ReceiveChannel<? extends E> $receiver, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.count($receiver, continuation);
    }

    public static final <E> Object count(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.count($receiver, predicate, continuation);
    }

    private static final Object count$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.count($receiver, predicate, continuation);
    }

    public static final <E> ReceiveChannel<E> distinct(ReceiveChannel<? extends E> $receiver) {
        return ChannelsKt__Channels_commonKt.distinct($receiver);
    }

    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> $receiver, CoroutineContext context, Function2<? super E, ? super Continuation<? super K>, ? extends Object> selector) {
        return ChannelsKt__Channels_commonKt.distinctBy($receiver, context, selector);
    }

    public static final <E> ReceiveChannel<E> drop(ReceiveChannel<? extends E> $receiver, int n, CoroutineContext context) {
        return ChannelsKt__Channels_commonKt.drop($receiver, n, context);
    }

    public static final <E> ReceiveChannel<E> dropWhile(ReceiveChannel<? extends E> $receiver, CoroutineContext context, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return ChannelsKt__Channels_commonKt.dropWhile($receiver, context, predicate);
    }

    public static final <E> Object elementAt(ReceiveChannel<? extends E> $receiver, int index, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.elementAt($receiver, index, continuation);
    }

    public static final <E> Object elementAtOrElse(ReceiveChannel<? extends E> $receiver, int index, Function1<? super Integer, ? extends E> defaultValue, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.elementAtOrElse($receiver, index, defaultValue, continuation);
    }

    private static final Object elementAtOrElse$$forInline(ReceiveChannel $receiver, int index, Function1 defaultValue, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.elementAtOrElse($receiver, index, defaultValue, continuation);
    }

    public static final <E> Object elementAtOrNull(ReceiveChannel<? extends E> $receiver, int index, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.elementAtOrNull($receiver, index, continuation);
    }

    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> $receiver, CoroutineContext context, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return ChannelsKt__Channels_commonKt.filter($receiver, context, predicate);
    }

    public static final <E> ReceiveChannel<E> filterIndexed(ReceiveChannel<? extends E> $receiver, CoroutineContext context, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return ChannelsKt__Channels_commonKt.filterIndexed($receiver, context, predicate);
    }

    public static final <E, C extends Collection<? super E>> Object filterIndexedTo(ReceiveChannel<? extends E> $receiver, C destination, Function2<? super Integer, ? super E, Boolean> predicate, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterIndexedTo($receiver, destination, predicate, continuation);
    }

    public static final <E, C extends SendChannel<? super E>> Object filterIndexedTo(ReceiveChannel<? extends E> $receiver, C destination, Function2<? super Integer, ? super E, Boolean> predicate, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterIndexedTo($receiver, destination, predicate, continuation);
    }

    private static final Object filterIndexedTo$$forInline(ReceiveChannel $receiver, Collection destination, Function2 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterIndexedTo($receiver, destination, predicate, continuation);
    }

    private static final Object filterIndexedTo$$forInline(ReceiveChannel $receiver, SendChannel destination, Function2 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterIndexedTo($receiver, destination, predicate, continuation);
    }

    public static final <E> ReceiveChannel<E> filterNot(ReceiveChannel<? extends E> $receiver, CoroutineContext context, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return ChannelsKt__Channels_commonKt.filterNot($receiver, context, predicate);
    }

    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> $receiver) {
        return ChannelsKt__Channels_commonKt.filterNotNull($receiver);
    }

    public static final <E, C extends Collection<? super E>> Object filterNotNullTo(ReceiveChannel<? extends E> $receiver, C destination, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterNotNullTo($receiver, destination, continuation);
    }

    public static final <E, C extends SendChannel<? super E>> Object filterNotNullTo(ReceiveChannel<? extends E> $receiver, C destination, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterNotNullTo($receiver, destination, continuation);
    }

    public static final <E, C extends Collection<? super E>> Object filterNotTo(ReceiveChannel<? extends E> $receiver, C destination, Function1<? super E, Boolean> predicate, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterNotTo($receiver, destination, predicate, continuation);
    }

    public static final <E, C extends SendChannel<? super E>> Object filterNotTo(ReceiveChannel<? extends E> $receiver, C destination, Function1<? super E, Boolean> predicate, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterNotTo($receiver, destination, predicate, continuation);
    }

    private static final Object filterNotTo$$forInline(ReceiveChannel $receiver, Collection destination, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterNotTo($receiver, destination, predicate, continuation);
    }

    private static final Object filterNotTo$$forInline(ReceiveChannel $receiver, SendChannel destination, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterNotTo($receiver, destination, predicate, continuation);
    }

    public static final <E, C extends Collection<? super E>> Object filterTo(ReceiveChannel<? extends E> $receiver, C destination, Function1<? super E, Boolean> predicate, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterTo($receiver, destination, predicate, continuation);
    }

    public static final <E, C extends SendChannel<? super E>> Object filterTo(ReceiveChannel<? extends E> $receiver, C destination, Function1<? super E, Boolean> predicate, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterTo($receiver, destination, predicate, continuation);
    }

    private static final Object filterTo$$forInline(ReceiveChannel $receiver, Collection destination, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterTo($receiver, destination, predicate, continuation);
    }

    private static final Object filterTo$$forInline(ReceiveChannel $receiver, SendChannel destination, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.filterTo($receiver, destination, predicate, continuation);
    }

    public static final <E> Object find(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.find($receiver, predicate, continuation);
    }

    private static final Object find$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.find($receiver, predicate, continuation);
    }

    public static final <E> Object findLast(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.findLast($receiver, predicate, continuation);
    }

    private static final Object findLast$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.findLast($receiver, predicate, continuation);
    }

    public static final <E> Object first(ReceiveChannel<? extends E> $receiver, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.first($receiver, continuation);
    }

    public static final <E> Object first(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.first($receiver, predicate, continuation);
    }

    private static final Object first$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.first($receiver, predicate, continuation);
    }

    public static final <E> Object firstOrNull(ReceiveChannel<? extends E> $receiver, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.firstOrNull($receiver, continuation);
    }

    public static final <E> Object firstOrNull(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.firstOrNull($receiver, predicate, continuation);
    }

    private static final Object firstOrNull$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.firstOrNull($receiver, predicate, continuation);
    }

    public static final <E, R> ReceiveChannel<R> flatMap(ReceiveChannel<? extends E> $receiver, CoroutineContext context, Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> transform) {
        return ChannelsKt__Channels_commonKt.flatMap($receiver, context, transform);
    }

    public static final <E, R> Object fold(ReceiveChannel<? extends E> $receiver, R initial, Function2<? super R, ? super E, ? extends R> operation, Continuation<? super R> continuation) {
        return ChannelsKt__Channels_commonKt.fold($receiver, initial, operation, continuation);
    }

    private static final Object fold$$forInline(ReceiveChannel $receiver, Object initial, Function2 operation, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.fold($receiver, initial, operation, continuation);
    }

    public static final <E, R> Object foldIndexed(ReceiveChannel<? extends E> $receiver, R initial, Function3<? super Integer, ? super R, ? super E, ? extends R> operation, Continuation<? super R> continuation) {
        return ChannelsKt__Channels_commonKt.foldIndexed($receiver, initial, operation, continuation);
    }

    private static final Object foldIndexed$$forInline(ReceiveChannel $receiver, Object initial, Function3 operation, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.foldIndexed($receiver, initial, operation, continuation);
    }

    public static final <E, K> Object groupBy(ReceiveChannel<? extends E> $receiver, Function1<? super E, ? extends K> keySelector, Continuation<? super Map<K, ? extends List<? extends E>>> continuation) {
        return ChannelsKt__Channels_commonKt.groupBy($receiver, keySelector, continuation);
    }

    public static final <E, K, V> Object groupBy(ReceiveChannel<? extends E> $receiver, Function1<? super E, ? extends K> keySelector, Function1<? super E, ? extends V> valueTransform, Continuation<? super Map<K, ? extends List<? extends V>>> continuation) {
        return ChannelsKt__Channels_commonKt.groupBy($receiver, keySelector, valueTransform, continuation);
    }

    private static final Object groupBy$$forInline(ReceiveChannel $receiver, Function1 keySelector, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.groupBy($receiver, keySelector, continuation);
    }

    private static final Object groupBy$$forInline(ReceiveChannel $receiver, Function1 keySelector, Function1 valueTransform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.groupBy($receiver, keySelector, valueTransform, continuation);
    }

    public static final <E, K, M extends Map<? super K, List<E>>> Object groupByTo(ReceiveChannel<? extends E> $receiver, M destination, Function1<? super E, ? extends K> keySelector, Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.groupByTo($receiver, destination, keySelector, continuation);
    }

    public static final <E, K, V, M extends Map<? super K, List<V>>> Object groupByTo(ReceiveChannel<? extends E> $receiver, M destination, Function1<? super E, ? extends K> keySelector, Function1<? super E, ? extends V> valueTransform, Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.groupByTo($receiver, destination, keySelector, valueTransform, continuation);
    }

    private static final Object groupByTo$$forInline(ReceiveChannel $receiver, Map destination, Function1 keySelector, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.groupByTo($receiver, destination, keySelector, continuation);
    }

    private static final Object groupByTo$$forInline(ReceiveChannel $receiver, Map destination, Function1 keySelector, Function1 valueTransform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.groupByTo($receiver, destination, keySelector, valueTransform, continuation);
    }

    public static final <E> Object indexOf(ReceiveChannel<? extends E> $receiver, E element, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.indexOf($receiver, element, continuation);
    }

    public static final <E> Object indexOfFirst(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.indexOfFirst($receiver, predicate, continuation);
    }

    private static final Object indexOfFirst$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.indexOfFirst($receiver, predicate, continuation);
    }

    public static final <E> Object indexOfLast(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.indexOfLast($receiver, predicate, continuation);
    }

    private static final Object indexOfLast$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.indexOfLast($receiver, predicate, continuation);
    }

    public static final <E> Object last(ReceiveChannel<? extends E> $receiver, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.last($receiver, continuation);
    }

    public static final <E> Object last(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.last($receiver, predicate, continuation);
    }

    private static final Object last$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.last($receiver, predicate, continuation);
    }

    public static final <E> Object lastIndexOf(ReceiveChannel<? extends E> $receiver, E element, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.lastIndexOf($receiver, element, continuation);
    }

    public static final <E> Object lastOrNull(ReceiveChannel<? extends E> $receiver, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.lastOrNull($receiver, continuation);
    }

    public static final <E> Object lastOrNull(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.lastOrNull($receiver, predicate, continuation);
    }

    private static final Object lastOrNull$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.lastOrNull($receiver, predicate, continuation);
    }

    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> $receiver, CoroutineContext context, Function2<? super E, ? super Continuation<? super R>, ? extends Object> transform) {
        return ChannelsKt__Channels_commonKt.map($receiver, context, transform);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> $receiver, CoroutineContext context, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> transform) {
        return ChannelsKt__Channels_commonKt.mapIndexed($receiver, context, transform);
    }

    public static final <E, R> ReceiveChannel<R> mapIndexedNotNull(ReceiveChannel<? extends E> $receiver, CoroutineContext context, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> transform) {
        return ChannelsKt__Channels_commonKt.mapIndexedNotNull($receiver, context, transform);
    }

    public static final <E, R, C extends Collection<? super R>> Object mapIndexedNotNullTo(ReceiveChannel<? extends E> $receiver, C destination, Function2<? super Integer, ? super E, ? extends R> transform, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedNotNullTo($receiver, destination, transform, continuation);
    }

    public static final <E, R, C extends SendChannel<? super R>> Object mapIndexedNotNullTo(ReceiveChannel<? extends E> $receiver, C destination, Function2<? super Integer, ? super E, ? extends R> transform, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedNotNullTo($receiver, destination, transform, continuation);
    }

    private static final Object mapIndexedNotNullTo$$forInline(ReceiveChannel $receiver, Collection destination, Function2 transform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedNotNullTo($receiver, destination, transform, continuation);
    }

    private static final Object mapIndexedNotNullTo$$forInline(ReceiveChannel $receiver, SendChannel destination, Function2 transform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedNotNullTo($receiver, destination, transform, continuation);
    }

    public static final <E, R, C extends Collection<? super R>> Object mapIndexedTo(ReceiveChannel<? extends E> $receiver, C destination, Function2<? super Integer, ? super E, ? extends R> transform, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedTo($receiver, destination, transform, continuation);
    }

    public static final <E, R, C extends SendChannel<? super R>> Object mapIndexedTo(ReceiveChannel<? extends E> $receiver, C destination, Function2<? super Integer, ? super E, ? extends R> transform, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedTo($receiver, destination, transform, continuation);
    }

    private static final Object mapIndexedTo$$forInline(ReceiveChannel $receiver, Collection destination, Function2 transform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedTo($receiver, destination, transform, continuation);
    }

    private static final Object mapIndexedTo$$forInline(ReceiveChannel $receiver, SendChannel destination, Function2 transform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedTo($receiver, destination, transform, continuation);
    }

    public static final <E, R> ReceiveChannel<R> mapNotNull(ReceiveChannel<? extends E> $receiver, CoroutineContext context, Function2<? super E, ? super Continuation<? super R>, ? extends Object> transform) {
        return ChannelsKt__Channels_commonKt.mapNotNull($receiver, context, transform);
    }

    public static final <E, R, C extends Collection<? super R>> Object mapNotNullTo(ReceiveChannel<? extends E> $receiver, C destination, Function1<? super E, ? extends R> transform, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapNotNullTo($receiver, destination, transform, continuation);
    }

    public static final <E, R, C extends SendChannel<? super R>> Object mapNotNullTo(ReceiveChannel<? extends E> $receiver, C destination, Function1<? super E, ? extends R> transform, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapNotNullTo($receiver, destination, transform, continuation);
    }

    private static final Object mapNotNullTo$$forInline(ReceiveChannel $receiver, Collection destination, Function1 transform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapNotNullTo($receiver, destination, transform, continuation);
    }

    private static final Object mapNotNullTo$$forInline(ReceiveChannel $receiver, SendChannel destination, Function1 transform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapNotNullTo($receiver, destination, transform, continuation);
    }

    public static final <E, R, C extends Collection<? super R>> Object mapTo(ReceiveChannel<? extends E> $receiver, C destination, Function1<? super E, ? extends R> transform, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapTo($receiver, destination, transform, continuation);
    }

    public static final <E, R, C extends SendChannel<? super R>> Object mapTo(ReceiveChannel<? extends E> $receiver, C destination, Function1<? super E, ? extends R> transform, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapTo($receiver, destination, transform, continuation);
    }

    private static final Object mapTo$$forInline(ReceiveChannel $receiver, Collection destination, Function1 transform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapTo($receiver, destination, transform, continuation);
    }

    private static final Object mapTo$$forInline(ReceiveChannel $receiver, SendChannel destination, Function1 transform, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.mapTo($receiver, destination, transform, continuation);
    }

    public static final <E, R extends Comparable<? super R>> Object maxBy(ReceiveChannel<? extends E> $receiver, Function1<? super E, ? extends R> selector, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.maxBy($receiver, selector, continuation);
    }

    private static final Object maxBy$$forInline(ReceiveChannel $receiver, Function1 selector, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.maxBy($receiver, selector, continuation);
    }

    public static final <E> Object maxWith(ReceiveChannel<? extends E> $receiver, Comparator<? super E> comparator, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.maxWith($receiver, comparator, continuation);
    }

    public static final <E, R extends Comparable<? super R>> Object minBy(ReceiveChannel<? extends E> $receiver, Function1<? super E, ? extends R> selector, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.minBy($receiver, selector, continuation);
    }

    private static final Object minBy$$forInline(ReceiveChannel $receiver, Function1 selector, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.minBy($receiver, selector, continuation);
    }

    public static final <E> Object minWith(ReceiveChannel<? extends E> $receiver, Comparator<? super E> comparator, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.minWith($receiver, comparator, continuation);
    }

    public static final <E> Object none(ReceiveChannel<? extends E> $receiver, Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.none($receiver, continuation);
    }

    public static final <E> Object none(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.none($receiver, predicate, continuation);
    }

    private static final Object none$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.none($receiver, predicate, continuation);
    }

    public static final <E> Object partition(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super Pair<? extends List<? extends E>, ? extends List<? extends E>>> continuation) {
        return ChannelsKt__Channels_commonKt.partition($receiver, predicate, continuation);
    }

    private static final Object partition$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.partition($receiver, predicate, continuation);
    }

    public static final <S, E extends S> Object reduce(ReceiveChannel<? extends E> $receiver, Function2<? super S, ? super E, ? extends S> operation, Continuation<? super S> continuation) {
        return ChannelsKt__Channels_commonKt.reduce($receiver, operation, continuation);
    }

    private static final Object reduce$$forInline(ReceiveChannel $receiver, Function2 operation, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.reduce($receiver, operation, continuation);
    }

    public static final <S, E extends S> Object reduceIndexed(ReceiveChannel<? extends E> $receiver, Function3<? super Integer, ? super S, ? super E, ? extends S> operation, Continuation<? super S> continuation) {
        return ChannelsKt__Channels_commonKt.reduceIndexed($receiver, operation, continuation);
    }

    private static final Object reduceIndexed$$forInline(ReceiveChannel $receiver, Function3 operation, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.reduceIndexed($receiver, operation, continuation);
    }

    public static final <E> ReceiveChannel<E> requireNoNulls(ReceiveChannel<? extends E> $receiver) {
        return ChannelsKt__Channels_commonKt.requireNoNulls($receiver);
    }

    public static final <E> void sendBlocking(SendChannel<? super E> $receiver, E element) {
        ChannelsKt__ChannelsKt.sendBlocking($receiver, element);
    }

    public static final <E> Object single(ReceiveChannel<? extends E> $receiver, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.single($receiver, continuation);
    }

    public static final <E> Object single(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.single($receiver, predicate, continuation);
    }

    private static final Object single$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.single($receiver, predicate, continuation);
    }

    public static final <E> Object singleOrNull(ReceiveChannel<? extends E> $receiver, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.singleOrNull($receiver, continuation);
    }

    public static final <E> Object singleOrNull(ReceiveChannel<? extends E> $receiver, Function1<? super E, Boolean> predicate, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.singleOrNull($receiver, predicate, continuation);
    }

    private static final Object singleOrNull$$forInline(ReceiveChannel $receiver, Function1 predicate, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.singleOrNull($receiver, predicate, continuation);
    }

    public static final <E> Object sumBy(ReceiveChannel<? extends E> $receiver, Function1<? super E, Integer> selector, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.sumBy($receiver, selector, continuation);
    }

    private static final Object sumBy$$forInline(ReceiveChannel $receiver, Function1 selector, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.sumBy($receiver, selector, continuation);
    }

    public static final <E> Object sumByDouble(ReceiveChannel<? extends E> $receiver, Function1<? super E, Double> selector, Continuation<? super Double> continuation) {
        return ChannelsKt__Channels_commonKt.sumByDouble($receiver, selector, continuation);
    }

    private static final Object sumByDouble$$forInline(ReceiveChannel $receiver, Function1 selector, Continuation continuation) {
        return ChannelsKt__Channels_commonKt.sumByDouble($receiver, selector, continuation);
    }

    public static final <E> ReceiveChannel<E> take(ReceiveChannel<? extends E> $receiver, int n, CoroutineContext context) {
        return ChannelsKt__Channels_commonKt.take($receiver, n, context);
    }

    public static final <E> ReceiveChannel<E> takeWhile(ReceiveChannel<? extends E> $receiver, CoroutineContext context, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        return ChannelsKt__Channels_commonKt.takeWhile($receiver, context, predicate);
    }

    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> $receiver, C destination, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.toChannel($receiver, destination, continuation);
    }

    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> $receiver, C destination, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.toCollection($receiver, destination, continuation);
    }

    public static final <E> Object toList(ReceiveChannel<? extends E> $receiver, Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.toList($receiver, continuation);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> $receiver, M destination, Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.toMap($receiver, destination, continuation);
    }

    public static final <K, V> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> $receiver, Continuation<? super Map<K, ? extends V>> continuation) {
        return ChannelsKt__Channels_commonKt.toMap($receiver, continuation);
    }

    public static final <E> Object toMutableList(ReceiveChannel<? extends E> $receiver, Continuation<? super List<E>> continuation) {
        return ChannelsKt__Channels_commonKt.toMutableList($receiver, continuation);
    }

    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> $receiver, Continuation<? super Set<E>> continuation) {
        return ChannelsKt__Channels_commonKt.toMutableSet($receiver, continuation);
    }

    public static final <E> Object toSet(ReceiveChannel<? extends E> $receiver, Continuation<? super Set<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.toSet($receiver, continuation);
    }

    public static final <E> ReceiveChannel<IndexedValue<E>> withIndex(ReceiveChannel<? extends E> $receiver, CoroutineContext context) {
        return ChannelsKt__Channels_commonKt.withIndex($receiver, context);
    }

    public static final <E, R> ReceiveChannel<Pair<E, R>> zip(ReceiveChannel<? extends E> $receiver, ReceiveChannel<? extends R> other) {
        return ChannelsKt__Channels_commonKt.zip($receiver, other);
    }

    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> $receiver, ReceiveChannel<? extends R> other, CoroutineContext context, Function2<? super E, ? super R, ? extends V> transform) {
        return ChannelsKt__Channels_commonKt.zip($receiver, other, context, transform);
    }
}
