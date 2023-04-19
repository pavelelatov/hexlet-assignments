package exercise;

import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {

    private final String path;

    public FileKV(
            String path,
            Map<String, String> data) {
        this.path = path;
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public void set(
            String key,
            String value) {
        var data = Utils.unserialize(Utils.readFile(path));
        data.put(key, value);
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        var data = Utils.unserialize(Utils.readFile(path));
        data.remove(key);
        Utils.writeFile(path, Utils.serialize(data));
    }

    @Override
    public String get(
            String key,
            String defaultValue) {
        return Utils.unserialize(Utils.readFile(path)).getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(path));
    }
}
// END
