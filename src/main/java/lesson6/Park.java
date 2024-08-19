package lesson6;

import utility.enums.AttractionType;
import utility.exceptions.TimeRange;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.*;

public class Park {
    private String name;
    private int area;
    private String address;
    private List<Attraction> attractions;

    public Park(String name, int area, String address) {
        this.name = name;
        this.area = area;
        this.address = address;
        this.attractions = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAttractions(List<Attraction> attractions) {
        this.attractions = attractions;
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public String getName() {
        return name;
    }

    public class Attraction {
        private static final LocalTime DEFAULT_OPEN_TIME = LocalTime.of(9, 0);
        private static final LocalTime DEFAULT_CLOSE_TIME = LocalTime.of(18, 0);

        private String name;
        private Date lastMaintenanceDate;
        private int minRideAge = 16;
        private int maxRideCapacity;
        private int rideCount = 0;
        private int buildYear;
        private int ridePriceUSD = 1;
        private Map<DayOfWeek, TimeRange> workSchedule;
        private AttractionType type;
        private int width;
        private int length;

        public int getBuildYear() {
            return buildYear;
        }

        public void setBuildYear(int buildYear) {
            this.buildYear = buildYear;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getLastMaintenanceDate() {
            return lastMaintenanceDate;
        }

        public void setLastMaintenanceDateAndResetRideCount(Date newDate) {
            if (lastMaintenanceDate.before(newDate))
            {
                this.lastMaintenanceDate = newDate;
                rideCount = 0;
            }
        }

        public int getMinRideAge() {
            return minRideAge;
        }

        public void setMinRideAge(int minRideAge) {
            this.minRideAge = minRideAge;
        }

        public int getMaxRideCapacity() {
            return maxRideCapacity;
        }

        public void setMaxRideCapacity(int maxRideCapacity) {
            this.maxRideCapacity = maxRideCapacity;
        }

        public int getRideCount() {
            return rideCount;
        }

        public void setRideCount(int rideCount) {
            this.rideCount = rideCount;
        }

        public int getRidePriceUSD() {
            return ridePriceUSD;
        }

        public void setRidePriceUSD(int ridePriceUSD) {
            this.ridePriceUSD = ridePriceUSD;
        }

        public AttractionType getType() {
            return type;
        }

        public void setType(AttractionType type) {
            this.type = type;
        }

        public void setWorkHours(DayOfWeek day, LocalTime openTime, LocalTime closeTime) {
            workSchedule.put(day, new TimeRange(openTime, closeTime));
        }

        public TimeRange getWorkHours(DayOfWeek day) {
            return workSchedule.get(day);
        }

        Attraction(String name, Date lastMaintenanceDate, int minRideAge, int rideCapacity, int buildYear, int ridePriceUSD, Map<DayOfWeek, TimeRange> workSchedule, AttractionType type, int length, int width) {
            this.name = name;
            this.lastMaintenanceDate = lastMaintenanceDate;
            this.minRideAge = minRideAge;
            this.maxRideCapacity = rideCapacity;
            this.buildYear = buildYear;
            this.ridePriceUSD = ridePriceUSD;
            this.workSchedule = workSchedule;
            this.type = type;
            this.length = length;
            this.width = width;

            initializeDefaultWorkSchedule();
        }

        private void initializeDefaultWorkSchedule() {
            workSchedule = new EnumMap<>(DayOfWeek.class);
            for (DayOfWeek day : DayOfWeek.values()) {
                workSchedule.put(day, new TimeRange(DEFAULT_OPEN_TIME, DEFAULT_CLOSE_TIME));
            }
        }

        public void printInfo() {
            printBasicInfo();
            printOperationalInfo();
            printTechnicalInfo();
        }

        public void printBasicInfo() {
            System.out.println("======= Основная информация =======");
            System.out.println("Название: " + name);
            System.out.println("Минимальный возраст: " + minRideAge);
            System.out.println("Цена: " + ridePriceUSD + "$");
            System.out.println("Расписание работы: " + workSchedule);
        }

        public void printOperationalInfo() {
            System.out.println("======= Эксплуатационные характеристики =======");
            System.out.println("Дата последнего обслуживания: " + lastMaintenanceDate);
            System.out.println("Максимальное количество использований до обслуживания: " + maxRideCapacity);
            System.out.println("Количество использований: " + rideCount);
            System.out.println("Аттракцион доступен для использования: " + (isOperational() ? "Да" : "Нет"));
        }

        private boolean isOperational() {
            return rideCount < maxRideCapacity;
        }

        public void printTechnicalInfo() {
            System.out.println("======= Технические характеристики =======");
            System.out.println("Дата постройки: " + buildYear);
            System.out.println("Тип аттракциона: " + type);
            System.out.println("Длина: " + length + " м");
            System.out.println("Ширина: " + width + " м");
        }

        public void printInfo(String infoType) {
            switch (infoType.toLowerCase()) {
                case "basic":
                    printBasicInfo();
                    break;
                case "operational":
                    printOperationalInfo();
                    break;
                case "technical":
                    printTechnicalInfo();
                    break;
                default:
                    System.out.println("Неизвестный тип информации. Доступные типы: basic, operational, technical");
            }
        }

        public boolean isOpenAt(DayOfWeek day, LocalTime time) {
            if (!isOperational()) {
                return false;
            }
            TimeRange range = workSchedule.get(day);
            return range != null && range.includes(time);
        }
    }
}
