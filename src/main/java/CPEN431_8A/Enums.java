package CPEN431_8A;

public class Enums {
    public enum ResponseCode {
        SUCCESS((byte) 0),
        NONEXISTENT_KEY((byte) 1),
        OUT_OF_SPACE((byte) 2),
        TEMP_SYSTEM_OVERLOAD((byte) 3),
        INTERNAL_KV_FAILURE((byte) 4),
        UNRECOGNIZED_COMMAND((byte) 5),
        INVALID_KEY((byte) 6),
        INVALID_VALUE((byte) 7);

        private final byte value;

        ResponseCode(byte value) {
            this.value = value;
        }

        public int value() {
            return value;
        }
    }

    public enum CommandCode {
        PUT((byte) 1),
        GET((byte) 2),
        REMOVE((byte) 3),
        SHUTDOWN((byte) 4),
        WIPEOUT((byte) 5),
        IS_ALIVE((byte) 6),
        GET_PID((byte) 7),
        HEALTH_CHECK((byte) 25),
        HEART_BEAT((byte) 26),
        EPIDEMIC((byte) 27),
        UNRECOGNIZED((byte) 30);

        private final byte value;

        CommandCode(byte value) {
            this.value = value;
        }

        public static CommandCode fromInteger(int x) {
            switch(x) {
                case 1: return PUT;
                case 2: return GET;
                case 3: return REMOVE;
                case 4: return SHUTDOWN;
                case 5: return WIPEOUT;
                case 6: return IS_ALIVE;
                case 7: return GET_PID;
                case 25: return HEALTH_CHECK;
                case 26: return HEART_BEAT;
                case 27: return EPIDEMIC;
                default: return UNRECOGNIZED;
            }
        }

        public int value() {
            return value;
        }
    }
}
