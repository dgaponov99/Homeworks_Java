package pack_2.task_1;

// Стащил с какого-то сайтика

public final class FNVHash {

    private static final long FNV_64_INIT = 0xcbf29ce484222325L;
    private static final long FNV_64_PRIME = 0x100000001b3L;

    private static final int FNV_32_INIT = 0x811c9dc5;
    private static final int FNV_32_PRIME = 0x01000193;

    public FNVHash() {
    }

    public static int hash32(final byte[] k) {
        int rv = FNV_32_INIT;
        for (byte aK : k) {
            rv ^= aK;
            rv *= FNV_32_PRIME;
        }
        return rv;
    }

    public static long hash64(final byte[] k) {
        long rv = FNV_64_INIT;
        for (byte aK : k) {
            rv ^= aK;
            rv *= FNV_64_PRIME;
        }
        return rv;
    }

    public static int hash32(final String k) {
        int rv = FNV_32_INIT;
        final int len = k.length();
        for (int i = 0; i < len; i++) {
            rv ^= k.charAt(i);
            rv *= FNV_32_PRIME;
        }
        return rv;
    }

    public static long hash64(final String k) {
        long rv = FNV_64_INIT;
        final int len = k.length();
        for (int i = 0; i < len; i++) {
            rv ^= k.charAt(i);
            rv *= FNV_64_PRIME;
        }
        return rv;
    }

}
