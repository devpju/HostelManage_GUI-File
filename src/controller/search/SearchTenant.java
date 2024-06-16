package controller.search;

import controller.manager.TenantManager;
import java.util.ArrayList;
import java.util.List;
import model.Tenant;

public class SearchTenant {

    private static List<Tenant> tenants = TenantManager.getInstance().getTenants();

    private SearchTenant() {
    }

    public static List<Tenant> searchAll(String text) {
        List<Tenant> result = new ArrayList<>();
        for (Tenant tenant : tenants) {
            if (tenant.getId().toLowerCase().contains(text.toLowerCase())
                    || tenant.getName().toLowerCase().contains(text.toLowerCase())
                    || tenant.getIdRoom().toLowerCase().contains(text.toLowerCase())
                    || tenant.getGender().toLowerCase().contains(text.toLowerCase())
                    || tenant.getPhone().contains(text)
                    || tenant.getAddress().toLowerCase().contains(text.toLowerCase())
                    || tenant.getContract().getStatus().toLowerCase().contains(text.toLowerCase())) {
                result.add(tenant);
            }
        }
        return result;
    }

    public static List<Tenant> searchById(String text) {
        List<Tenant> result = new ArrayList<>();
        for (Tenant tenant : tenants) {
            if (tenant.getId().toLowerCase().contains(text.toLowerCase())) {
                result.add(tenant);
            }
        }
        return result;
    }

    public static List<Tenant> searchByName(String text) {
        List<Tenant> result = new ArrayList<>();
        for (Tenant tenant : tenants) {
            if (tenant.getName().toLowerCase().contains(text.toLowerCase())) {
                result.add(tenant);
            }
        }
        return result;
    }

    public static List<Tenant> searchByIdRoom(String text) {
        List<Tenant> result = new ArrayList<>();
        for (Tenant tenant : tenants) {
            if (tenant.getIdRoom().toLowerCase().contains(text.toLowerCase())) {
                result.add(tenant);
            }
        }
        return result;
    }

    public static List<Tenant> searchByGender(String text) {
        List<Tenant> result = new ArrayList<>();
        for (Tenant tenant : tenants) {
            if (tenant.getGender().toLowerCase().contains(text.toLowerCase())) {
                result.add(tenant);
            }
        }
        return result;
    }

    public static List<Tenant> searchByPhone(String text) {
        List<Tenant> result = new ArrayList<>();
        for (Tenant tenant : tenants) {
            if (tenant.getPhone().contains(text)) {
                result.add(tenant);
            }
        }
        return result;
    }

    public static List<Tenant> searchByAddress(String text) {
        List<Tenant> result = new ArrayList<>();
        for (Tenant tenant : tenants) {
            if (tenant.getAddress().toLowerCase().contains(text.toLowerCase())) {
                result.add(tenant);
            }
        }
        return result;
    }

    public static List<Tenant> searchByStatusContract(String text) {
        List<Tenant> result = new ArrayList<>();
        for (Tenant tenant : tenants) {
            if (tenant.getContract().getStatus().toLowerCase().contains(text.toLowerCase())) {
                result.add(tenant);
            }
        }
        return result;
    }
}
