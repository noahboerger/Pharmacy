package Cabinet;

import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

public class Drug implements Comparable<Drug> {
    UUID id;
    String label;
    Date expirationDate;
    String category;

    public Drug(String label, Date expirationDate, String category) {
        if (isLabelCorrect(label)) {
            this.id = UUID.randomUUID();
            this.label = label;
            this.expirationDate = expirationDate;
            this.category = category;
        } else {
            return;
        }
    }

    private boolean isLabelCorrect(String label) {
        if (label.length() != 5) {
            return false;
        }
        char firstChar = label.charAt(0);
        char secondChar = label.charAt(1);
        if (!(firstChar >= 'A' && firstChar <= 'Z') && (secondChar >= 'A' && secondChar <= 'Z')) {
            return false;
        }
        String numberString = label.substring(2, 5);
        try {
            Integer.parseInt(numberString);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int compareTo(Drug drug) {
        if (drug == null) {

            return 1;
        }
        if (!label.equals(drug.label)) {
            return label.compareTo(drug.label);
        } else if (expirationDate != null && !expirationDate.equals(drug.expirationDate)) {
            return expirationDate.compareTo(drug.expirationDate);
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Drug[id=" + id + " label=" + label + " expirationDate=" + expirationDate + " category=" + category + "]";
    }

    public boolean checkExpirationDate() {
        if (expirationDate.before(new Date(System.currentTimeMillis() + 10 * 60 * 60 * 24 * 3))) {
            return false;
        } else {
            return true;
        }
    }
}
