package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double total = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                total += subject.getScore();
                count += 1;
            }
        }
        return total / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int count = 0;
            double total = 0;
            for (Subject subject : pupil.subjects()) {
                if (count <= pupil.subjects().size()) {
                    total += subject.getScore();
                    count += 1;
                }
                if (count == pupil.subjects().size()) {
                    double scoreAv = total / count;
                    Label label = new Label(pupil.name(), scoreAv);
                    rsl.add(label);
                    break;
                }
            }
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (temp.containsKey(subject.getName())) {
                    temp.put(subject.getName(), temp.get(subject.getName()) + subject.getScore());
                } else {
                    temp.put(subject.getName(), subject.getScore());
                }
            }
        }
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            int scoreAv = entry.getValue() / pupils.size();
            Label label = new Label(entry.getKey(), scoreAv);
            rsl.add(label);
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int count = 0;
            double total = 0;
            for (Subject subject : pupil.subjects()) {
                if (count <= pupil.subjects().size()) {
                    total += subject.getScore();
                    count += 1;
                }
                if (count == pupil.subjects().size()) {
                    Label label = new Label(pupil.name(), total);
                    rsl.add(label);
                    break;
                }
            }
        }
        Collections.sort(rsl);
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (temp.containsKey(subject.getName())) {
                    temp.put(subject.getName(), temp.get(subject.getName()) + subject.getScore());
                } else {
                    temp.put(subject.getName(), subject.getScore());
                }
            }
        }
        for (Map.Entry<String, Integer> entry : temp.entrySet()) {
            Label label = new Label(entry.getKey(), entry.getValue());
            rsl.add(label);
        }
        Collections.sort(rsl);
        return rsl.get(rsl.size() - 1);
    }
}
