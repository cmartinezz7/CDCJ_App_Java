package com.google.android.libraries.places.internal;

/* compiled from: com.google.android.libraries.places:places@@2.0.0 */
final class zzbx {
    private zzb[] addressComponents;
    private String formattedAddress;
    private zza geometry;
    private String icon;
    private String internationalPhoneNumber;
    private String name;
    private zzc openingHours;
    private zzd[] photos;
    private String placeId;
    private zze plusCode;
    private Integer priceLevel;
    private Double rating;
    private String[] types;
    private Integer userRatingsTotal;
    private Integer utcOffset;
    private String website;

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    static class zza {
        private zzb location;
        private C0000zza viewport;

        /* renamed from: com.google.android.libraries.places.internal.zzbx$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        static class C0000zza {
            private zzb northeast;
            private zzb southwest;

            C0000zza() {
            }

            /* access modifiers changed from: package-private */
            public final zzb zza() {
                return this.northeast;
            }

            /* access modifiers changed from: package-private */
            public final zzb zzb() {
                return this.southwest;
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        static class zzb {
            private Double lat;
            private Double lng;

            zzb() {
            }

            /* access modifiers changed from: package-private */
            public final Double zza() {
                return this.lat;
            }

            /* access modifiers changed from: package-private */
            public final Double zzb() {
                return this.lng;
            }
        }

        zza() {
        }

        /* access modifiers changed from: package-private */
        public final zzb zza() {
            return this.location;
        }

        /* access modifiers changed from: package-private */
        public final C0000zza zzb() {
            return this.viewport;
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    static class zzb {
        private String longName;
        private String shortName;
        private String[] types;

        zzb() {
        }

        /* access modifiers changed from: package-private */
        public final String zza() {
            return this.longName;
        }

        /* access modifiers changed from: package-private */
        public final String zzb() {
            return this.shortName;
        }

        /* access modifiers changed from: package-private */
        public final zzgv<String> zzc() {
            String[] strArr = this.types;
            if (strArr != null) {
                return zzgv.zza((E[]) strArr);
            }
            return null;
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    static class zzc {
        private zza[] periods;
        private String[] weekdayText;

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        static class zza {
            private zzb close;
            private zzb open;

            zza() {
            }

            /* access modifiers changed from: package-private */
            public final zzb zza() {
                return this.close;
            }

            /* access modifiers changed from: package-private */
            public final zzb zzb() {
                return this.open;
            }
        }

        /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
        static class zzb {
            private Integer day;
            private String time;

            zzb() {
            }

            /* access modifiers changed from: package-private */
            public final Integer zza() {
                return this.day;
            }

            /* access modifiers changed from: package-private */
            public final String zzb() {
                return this.time;
            }
        }

        zzc() {
        }

        /* access modifiers changed from: package-private */
        public final zzgv<zza> zza() {
            zza[] zzaArr = this.periods;
            if (zzaArr != null) {
                return zzgv.zza((E[]) zzaArr);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final zzgv<String> zzb() {
            String[] strArr = this.weekdayText;
            if (strArr != null) {
                return zzgv.zza((E[]) strArr);
            }
            return null;
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    static class zzd {
        private Integer height;
        private String[] htmlAttributions;
        private String photoReference;
        private Integer width;

        zzd() {
        }

        /* access modifiers changed from: package-private */
        public final Integer zza() {
            return this.height;
        }

        /* access modifiers changed from: package-private */
        public final Integer zzb() {
            return this.width;
        }

        /* access modifiers changed from: package-private */
        public final String zzc() {
            return this.photoReference;
        }

        /* access modifiers changed from: package-private */
        public final zzgv<String> zzd() {
            String[] strArr = this.htmlAttributions;
            if (strArr != null) {
                return zzgv.zza((E[]) strArr);
            }
            return null;
        }
    }

    /* compiled from: com.google.android.libraries.places:places@@2.0.0 */
    static class zze {
        private String compoundCode;
        private String globalCode;

        zze() {
        }

        /* access modifiers changed from: package-private */
        public final String zza() {
            return this.compoundCode;
        }

        /* access modifiers changed from: package-private */
        public final String zzb() {
            return this.globalCode;
        }
    }

    zzbx() {
    }

    /* access modifiers changed from: package-private */
    public final zzgv<zzb> zza() {
        zzb[] zzbArr = this.addressComponents;
        if (zzbArr != null) {
            return zzgv.zza((E[]) zzbArr);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final String zzb() {
        return this.formattedAddress;
    }

    /* access modifiers changed from: package-private */
    public final zza zzc() {
        return this.geometry;
    }

    /* access modifiers changed from: package-private */
    public final String zzd() {
        return this.internationalPhoneNumber;
    }

    /* access modifiers changed from: package-private */
    public final String zze() {
        return this.name;
    }

    /* access modifiers changed from: package-private */
    public final zzc zzf() {
        return this.openingHours;
    }

    /* access modifiers changed from: package-private */
    public final zzgv<zzd> zzg() {
        zzd[] zzdArr = this.photos;
        if (zzdArr != null) {
            return zzgv.zza((E[]) zzdArr);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final String zzh() {
        return this.placeId;
    }

    /* access modifiers changed from: package-private */
    public final zze zzi() {
        return this.plusCode;
    }

    /* access modifiers changed from: package-private */
    public final Integer zzj() {
        return this.priceLevel;
    }

    /* access modifiers changed from: package-private */
    public final Double zzk() {
        return this.rating;
    }

    /* access modifiers changed from: package-private */
    public final zzgv<String> zzl() {
        String[] strArr = this.types;
        if (strArr != null) {
            return zzgv.zza((E[]) strArr);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Integer zzm() {
        return this.userRatingsTotal;
    }

    /* access modifiers changed from: package-private */
    public final Integer zzn() {
        return this.utcOffset;
    }

    /* access modifiers changed from: package-private */
    public final String zzo() {
        return this.website;
    }
}
