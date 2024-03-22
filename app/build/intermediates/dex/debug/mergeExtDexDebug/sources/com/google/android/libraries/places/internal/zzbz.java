package com.google.android.libraries.places.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.model.AddressComponent;
import com.google.android.libraries.places.api.model.AddressComponents;
import com.google.android.libraries.places.api.model.DayOfWeek;
import com.google.android.libraries.places.api.model.LocalTime;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.Period;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlusCode;
import com.google.android.libraries.places.api.model.TimeOfWeek;
import com.google.android.libraries.places.internal.zzbx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzbz {
    private static final zzha<String, Place.Type> zza = new zzgz().zza("accounting", Place.Type.ACCOUNTING).zza("administrative_area_level_1", Place.Type.ADMINISTRATIVE_AREA_LEVEL_1).zza("administrative_area_level_2", Place.Type.ADMINISTRATIVE_AREA_LEVEL_2).zza("administrative_area_level_3", Place.Type.ADMINISTRATIVE_AREA_LEVEL_3).zza("administrative_area_level_4", Place.Type.ADMINISTRATIVE_AREA_LEVEL_4).zza("administrative_area_level_5", Place.Type.ADMINISTRATIVE_AREA_LEVEL_5).zza("airport", Place.Type.AIRPORT).zza("amusement_park", Place.Type.AMUSEMENT_PARK).zza("aquarium", Place.Type.AQUARIUM).zza("art_gallery", Place.Type.ART_GALLERY).zza("atm", Place.Type.ATM).zza("bakery", Place.Type.BAKERY).zza("bank", Place.Type.BANK).zza("bar", Place.Type.BAR).zza("beauty_salon", Place.Type.BEAUTY_SALON).zza("bicycle_store", Place.Type.BICYCLE_STORE).zza("book_store", Place.Type.BOOK_STORE).zza("bowling_alley", Place.Type.BOWLING_ALLEY).zza("bus_station", Place.Type.BUS_STATION).zza("cafe", Place.Type.CAFE).zza("campground", Place.Type.CAMPGROUND).zza("car_dealer", Place.Type.CAR_DEALER).zza("car_rental", Place.Type.CAR_RENTAL).zza("car_repair", Place.Type.CAR_REPAIR).zza("car_wash", Place.Type.CAR_WASH).zza("casino", Place.Type.CASINO).zza("cemetery", Place.Type.CEMETERY).zza("church", Place.Type.CHURCH).zza("city_hall", Place.Type.CITY_HALL).zza("clothing_store", Place.Type.CLOTHING_STORE).zza("colloquial_area", Place.Type.COLLOQUIAL_AREA).zza("convenience_store", Place.Type.CONVENIENCE_STORE).zza("country", Place.Type.COUNTRY).zza("courthouse", Place.Type.COURTHOUSE).zza("dentist", Place.Type.DENTIST).zza("department_store", Place.Type.DEPARTMENT_STORE).zza("doctor", Place.Type.DOCTOR).zza("electrician", Place.Type.ELECTRICIAN).zza("electronics_store", Place.Type.ELECTRONICS_STORE).zza("embassy", Place.Type.EMBASSY).zza("establishment", Place.Type.ESTABLISHMENT).zza("finance", Place.Type.FINANCE).zza("fire_station", Place.Type.FIRE_STATION).zza("floor", Place.Type.FLOOR).zza("florist", Place.Type.FLORIST).zza("food", Place.Type.FOOD).zza("funeral_home", Place.Type.FUNERAL_HOME).zza("furniture_store", Place.Type.FURNITURE_STORE).zza("gas_station", Place.Type.GAS_STATION).zza("general_contractor", Place.Type.GENERAL_CONTRACTOR).zza("geocode", Place.Type.GEOCODE).zza("grocery_or_supermarket", Place.Type.GROCERY_OR_SUPERMARKET).zza("gym", Place.Type.GYM).zza("hair_care", Place.Type.HAIR_CARE).zza("hardware_store", Place.Type.HARDWARE_STORE).zza("health", Place.Type.HEALTH).zza("hindu_temple", Place.Type.HINDU_TEMPLE).zza("home_goods_store", Place.Type.HOME_GOODS_STORE).zza("hospital", Place.Type.HOSPITAL).zza("insurance_agency", Place.Type.INSURANCE_AGENCY).zza("intersection", Place.Type.INTERSECTION).zza("jewelry_store", Place.Type.JEWELRY_STORE).zza("laundry", Place.Type.LAUNDRY).zza("lawyer", Place.Type.LAWYER).zza("library", Place.Type.LIBRARY).zza("liquor_store", Place.Type.LIQUOR_STORE).zza("local_government_office", Place.Type.LOCAL_GOVERNMENT_OFFICE).zza("locality", Place.Type.LOCALITY).zza("locksmith", Place.Type.LOCKSMITH).zza("lodging", Place.Type.LODGING).zza("meal_delivery", Place.Type.MEAL_DELIVERY).zza("meal_takeaway", Place.Type.MEAL_TAKEAWAY).zza("mosque", Place.Type.MOSQUE).zza("movie_rental", Place.Type.MOVIE_RENTAL).zza("movie_theater", Place.Type.MOVIE_THEATER).zza("moving_company", Place.Type.MOVING_COMPANY).zza("museum", Place.Type.MUSEUM).zza("natural_feature", Place.Type.NATURAL_FEATURE).zza("neighborhood", Place.Type.NEIGHBORHOOD).zza("night_club", Place.Type.NIGHT_CLUB).zza("painter", Place.Type.PAINTER).zza("park", Place.Type.PARK).zza("parking", Place.Type.PARKING).zza("pet_store", Place.Type.PET_STORE).zza("pharmacy", Place.Type.PHARMACY).zza("physiotherapist", Place.Type.PHYSIOTHERAPIST).zza("place_of_worship", Place.Type.PLACE_OF_WORSHIP).zza("plumber", Place.Type.PLUMBER).zza("point_of_interest", Place.Type.POINT_OF_INTEREST).zza("police", Place.Type.POLICE).zza("political", Place.Type.POLITICAL).zza("post_box", Place.Type.POST_BOX).zza("post_office", Place.Type.POST_OFFICE).zza("postal_code", Place.Type.POSTAL_CODE).zza("postal_code_prefix", Place.Type.POSTAL_CODE_PREFIX).zza("postal_code_suffix", Place.Type.POSTAL_CODE_SUFFIX).zza("postal_town", Place.Type.POSTAL_TOWN).zza("premise", Place.Type.PREMISE).zza("real_estate_agency", Place.Type.REAL_ESTATE_AGENCY).zza("restaurant", Place.Type.RESTAURANT).zza("roofing_contractor", Place.Type.ROOFING_CONTRACTOR).zza("room", Place.Type.ROOM).zza("route", Place.Type.ROUTE).zza("rv_park", Place.Type.RV_PARK).zza("school", Place.Type.SCHOOL).zza("shoe_store", Place.Type.SHOE_STORE).zza("shopping_mall", Place.Type.SHOPPING_MALL).zza("spa", Place.Type.SPA).zza("stadium", Place.Type.STADIUM).zza("street_address", Place.Type.STREET_ADDRESS).zza("storage", Place.Type.STORAGE).zza("store", Place.Type.STORE).zza("sublocality", Place.Type.SUBLOCALITY).zza("sublocality_level_1", Place.Type.SUBLOCALITY_LEVEL_1).zza("sublocality_level_2", Place.Type.SUBLOCALITY_LEVEL_2).zza("sublocality_level_3", Place.Type.SUBLOCALITY_LEVEL_3).zza("sublocality_level_4", Place.Type.SUBLOCALITY_LEVEL_4).zza("sublocality_level_5", Place.Type.SUBLOCALITY_LEVEL_5).zza("subpremise", Place.Type.SUBPREMISE).zza("subway_station", Place.Type.SUBWAY_STATION).zza("supermarket", Place.Type.SUPERMARKET).zza("synagogue", Place.Type.SYNAGOGUE).zza("taxi_stand", Place.Type.TAXI_STAND).zza("train_station", Place.Type.TRAIN_STATION).zza("transit_station", Place.Type.TRANSIT_STATION).zza("travel_agency", Place.Type.TRAVEL_AGENCY).zza("university", Place.Type.UNIVERSITY).zza("veterinary_care", Place.Type.VETERINARY_CARE).zza("zoo", Place.Type.ZOO).zza();

    static Place zza(zzbx zzbx, List<String> list) throws ApiException {
        AddressComponents addressComponents;
        LatLngBounds latLngBounds;
        LatLng latLng;
        Uri uri;
        ArrayList arrayList;
        OpeningHours openingHours;
        ArrayList arrayList2;
        Period period;
        PhotoMetadata photoMetadata;
        String str;
        Place.Builder builder = Place.builder();
        builder.setAttributions(list);
        if (zzbx != null) {
            zzgv<zzbx.zzb> zza2 = zzbx.zza();
            int i = 0;
            PlusCode plusCode = null;
            if (zza2 == null) {
                addressComponents = null;
            } else {
                ArrayList arrayList3 = new ArrayList();
                zzgv zzgv = zza2;
                int size = zzgv.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = zzgv.get(i2);
                    i2++;
                    zza(arrayList3, zza((zzbx.zzb) obj));
                }
                addressComponents = AddressComponents.newInstance(arrayList3);
            }
            zzbx.zza zzc = zzbx.zzc();
            if (zzc != null) {
                latLng = zza(zzc.zza());
                zzbx.zza.C0000zza zzb = zzc.zzb();
                if (zzb == null) {
                    latLngBounds = null;
                } else {
                    LatLng zza3 = zza(zzb.zzb());
                    LatLng zza4 = zza(zzb.zza());
                    if (zza3 == null || zza4 == null) {
                        latLngBounds = null;
                    } else {
                        latLngBounds = new LatLngBounds(zza3, zza4);
                    }
                }
            } else {
                latLng = null;
                latLngBounds = null;
            }
            String zzo = zzbx.zzo();
            if (zzo != null) {
                uri = Uri.parse(zzo);
            } else {
                uri = null;
            }
            Place.Builder phoneNumber = builder.setAddress(zzbx.zzb()).setAddressComponents(addressComponents).setId(zzbx.zzh()).setLatLng(latLng).setName(zzbx.zze()).setPhoneNumber(zzbx.zzd());
            zzgv<zzbx.zzd> zzg = zzbx.zzg();
            if (zzg != null) {
                arrayList = new ArrayList();
                zzgv zzgv2 = zzg;
                int size2 = zzgv2.size();
                int i3 = 0;
                while (i3 < size2) {
                    Object obj2 = zzgv2.get(i3);
                    i3++;
                    zzbx.zzd zzd = (zzbx.zzd) obj2;
                    if (zzd == null) {
                        photoMetadata = null;
                    } else if (!TextUtils.isEmpty(zzd.zzc())) {
                        Integer zza5 = zzd.zza();
                        Integer zzb2 = zzd.zzb();
                        PhotoMetadata.Builder builder2 = PhotoMetadata.builder(zzd.zzc());
                        zzgv<String> zzd2 = zzd.zzd();
                        if (zzd2 == null || zzd2.isEmpty()) {
                            str = "";
                        } else {
                            str = zzfz.zza(", ").zza().zza((Iterable<?>) zzd2);
                        }
                        photoMetadata = builder2.setAttributions(str).setHeight(zza5 == null ? 0 : zza5.intValue()).setWidth(zzb2 == null ? 0 : zzb2.intValue()).build();
                    } else {
                        throw zzb("Photo reference not provided for a PhotoMetadata result.");
                    }
                    zza(arrayList, photoMetadata);
                }
            } else {
                arrayList = null;
            }
            Place.Builder photoMetadatas = phoneNumber.setPhotoMetadatas(arrayList);
            zzbx.zzc zzf = zzbx.zzf();
            if (zzf != null) {
                OpeningHours.Builder builder3 = OpeningHours.builder();
                zzgv<zzbx.zzc.zza> zza6 = zzf.zza();
                if (zza6 != null) {
                    arrayList2 = new ArrayList();
                    zzgv zzgv3 = zza6;
                    int size3 = zzgv3.size();
                    while (i < size3) {
                        Object obj3 = zzgv3.get(i);
                        i++;
                        zzbx.zzc.zza zza7 = (zzbx.zzc.zza) obj3;
                        if (zza7 != null) {
                            period = Period.builder().setOpen(zza(zza7.zzb())).setClose(zza(zza7.zza())).build();
                        } else {
                            period = null;
                        }
                        zza(arrayList2, period);
                    }
                } else {
                    arrayList2 = null;
                }
                openingHours = builder3.setPeriods(zzb(arrayList2)).setWeekdayText(zzb(zzf.zzb())).build();
            } else {
                openingHours = null;
            }
            Place.Builder openingHours2 = photoMetadatas.setOpeningHours(openingHours);
            zzbx.zze zzi = zzbx.zzi();
            if (zzi != null) {
                plusCode = PlusCode.builder().setCompoundCode(zzi.zza()).setGlobalCode(zzi.zzb()).build();
            }
            openingHours2.setPlusCode(plusCode).setPriceLevel(zzbx.zzj()).setRating(zzbx.zzk()).setTypes(zza((List<String>) zzbx.zzl())).setUserRatingsTotal(zzbx.zzm()).setUtcOffsetMinutes(zzbx.zzn()).setViewport(latLngBounds).setWebsiteUri(uri);
        }
        return builder.build();
    }

    private static AddressComponent zza(zzbx.zzb zzb) throws ApiException {
        if (zzb == null) {
            return null;
        }
        try {
            return AddressComponent.builder(zzb.zza(), zzb.zzc()).setShortName(zzb.zzb()).build();
        } catch (IllegalStateException | NullPointerException e) {
            throw zzb(String.format("AddressComponent not properly defined (%s).", new Object[]{e.getMessage()}));
        }
    }

    private static TimeOfWeek zza(zzbx.zzc.zzb zzb) {
        DayOfWeek dayOfWeek;
        if (zzb == null) {
            return null;
        }
        boolean z = true;
        zzgg.zza(zzb.zza() != null, (Object) "Unable to convert Pablo response to TimeOfWeek: The \"day\" field is missing.");
        if (zzb.zzb() == null) {
            z = false;
        }
        zzgg.zza(z, (Object) "Unable to convert Pablo response to TimeOfWeek: The \"time\" field is missing.");
        switch (zzb.zza().intValue()) {
            case 0:
                dayOfWeek = DayOfWeek.SUNDAY;
                break;
            case 1:
                dayOfWeek = DayOfWeek.MONDAY;
                break;
            case 2:
                dayOfWeek = DayOfWeek.TUESDAY;
                break;
            case 3:
                dayOfWeek = DayOfWeek.WEDNESDAY;
                break;
            case 4:
                dayOfWeek = DayOfWeek.THURSDAY;
                break;
            case 5:
                dayOfWeek = DayOfWeek.FRIDAY;
                break;
            case 6:
                dayOfWeek = DayOfWeek.SATURDAY;
                break;
            default:
                throw new IllegalArgumentException("pabloDayOfWeek can only be an integer between 0 and 6");
        }
        return TimeOfWeek.newInstance(dayOfWeek, zza(zzb.zzb()));
    }

    private static LocalTime zza(String str) {
        if (str == null) {
            return null;
        }
        boolean z = true;
        String format = String.format("Unable to convert %s to LocalTime, must be of format \"hhmm\".", new Object[]{str});
        if (str.length() != 4) {
            z = false;
        }
        zzgg.zza(z, (Object) format);
        try {
            return LocalTime.newInstance(Integer.parseInt(str.substring(0, 2)), Integer.parseInt(str.substring(2, 4)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(format, e);
        }
    }

    static List<Place.Type> zza(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (String next : list) {
            zzha<String, Place.Type> zzha = zza;
            if (zzha.containsKey(next)) {
                arrayList.add(zzha.get(next));
            } else {
                z = true;
            }
        }
        if (z) {
            arrayList.add(Place.Type.OTHER);
        }
        return arrayList;
    }

    private static LatLng zza(zzbx.zza.zzb zzb) {
        if (zzb == null || zzb.zza() == null || zzb.zzb() == null) {
            return null;
        }
        return new LatLng(zzb.zza().doubleValue(), zzb.zzb().doubleValue());
    }

    private static ApiException zzb(String str) {
        String valueOf = String.valueOf(str);
        return new ApiException(new Status(8, valueOf.length() != 0 ? "Unexpected server error: ".concat(valueOf) : new String("Unexpected server error: ")));
    }

    static <T> List<T> zzb(List<T> list) {
        return list != null ? list : new ArrayList();
    }

    private static <T> boolean zza(Collection<T> collection, T t) {
        if (t != null) {
            return collection.add(t);
        }
        return false;
    }
}
