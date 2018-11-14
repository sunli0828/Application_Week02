package application_week02.application_week02;

import java.util.List;

public class MyBean {

    public List<Result> result;
    public List<Result> getResult() { return result; }
    public void setResult(List<Result> result) { this.result = result; }

    public static class Result {
        public String actors;
        public String also_known_as;
        public String country;
        public String plot_simple;
        public String poster;

        public String getPoster() { return poster; }
        public void setPoster(String poster) { this.poster = poster; }

        public String getActors() { return actors; }
        public void setActors(String actors) { this.actors = actors; }

        public String getAlso_known_as() { return also_known_as; }
        public void setAlso_known_as(String also_known_as) {
            this.also_known_as = also_known_as;
        }

        public String getCountry() { return country; }
        public void setCountry(String country) { this.country = country; }

        public String getPlot_simple() { return plot_simple; }
        public void setPlot_simple(String plot_simple) {
            this.plot_simple = plot_simple;
        }
    }
}
