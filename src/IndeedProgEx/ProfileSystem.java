package IndeedProgEx;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/*
然后就开始上机。Hackerrank的，还装模作样的显示是5道题，其实4道题都是文字叙述做法。之前已经押题是Resume version。就是一个简历系统（Profile system），
实现update和query。我的办法是建个Profile class，里面成员变量有一个Profile id，和一个List，List里面是Map，因为它query的时候要根据版本号（version number），
所以用list里面的index对应。每次更新的时候就把最新的map复制出来，修改再塞回List里面去。case一共是20个，超时了9个。而且近期应该都不会变了，
连安排面试的人手都不够怎么可能去换上机题。

https://www.1point3acres.com/bbs/thread-223228-1-1.html

/* =============================================================================
题目内容：
=============================================================================*/
/*
说实现一个简历的系统，3个API
        1) update(String profileId, String field, String value); //这时候版本要+1
        2) get(String profileId, int version); //找对应版本的field和value
        3) getField(String profileId, int version, String field); //找对应的value

        一上来没什么想法，只能硬做。写一个类，里面包含四个变量，profileId, field, value还有version
        然后建map，key是id，value就是后面的三个东西吧。
        value应该也弄个map，key是version，value再来个map，key是field。
        真是圈套圈。
        目前能想到的就这么多了。
        /* =============================================================================
        地里面经总结
        =============================================================================*/
/*
        HackerRank 新题，我的解法不够优，很多大数据点超时了。大概是一个简历的系统，实现三个 API
        1) update(String profileId, String field, String value);
        2) get(String profileId, int version);
        3) getField(String profileId, int version, String field);

        每个用户有一个 profile，然后 profile 里有各种 field 和对应的 value，第一次 update 之后的 version 是 1，
        再 update version 变成 2，依此类推。
        虽然是 online HackerRank，但是是有面试官坐旁边随时解答问题的。我习惯了 HackerRank 就闷头做题，想了两个思路，
        没有和面试官交流就直接写了一种（他倒也说了不用和他讲思路，直接做题就好）。

 /
*/



public class ProfileSystem {
        class Profile {
            String id;
            int version;// current version
            //version id -> profile
            // profile = map < file->value>
            // if we want to sort the version id, we can use treemap, a map is sorted according to the key
            //TreeMap<Integer, Map<String, String>> versionToMap;
            Map<Integer,Map<String,String>> versionToMap;
            public Profile(String id) {
                this.id = id;
                this.version = 1;
                //versionToMap = new TreeMap<>();
                versionToMap = new HashMap<>();
                versionToMap.put(1, new HashMap<>());
            }
        }
        // for whole system, id -> profile
        Map<String, Profile> profiles;
        public ProfileSystem() {
            profiles = new HashMap<>();
        }

        public void update(String profileId, String field, String value) {
            if (!profiles.containsKey(profileId)) {
                Profile profile = new Profile(profileId);
                // version = 1
                profile.versionToMap.get(profile.version).put(field, value);
                profiles.put(profileId, profile);
            } else {
                Profile profile = profiles.get(profileId);
                Map<String, String> fields = profile.versionToMap.get(profile.version);
                /*
                * update(ABC, "skills", "java")------>对应版本1
                  update(ABC, "skills", "python")------>对应版本2，因为同样的key里面增加了新的元素
                  update(ABC, "education", "USC")------>对应版本2，因为education这个key是新key

                * */
                //如果我们call Get(ABC, 版本2)，那么应该返回{ABC:{"skills" : "java, python", "education": "USC"}}
                if (fields.containsKey(field)) {
                    profile.versionToMap.put(profile.version + 1, new HashMap<>(fields));
                    profile.version++;
                    profile.versionToMap.get(profile.version).put(field, fields.get(field) + ", " + value);

                } else {
                    fields.put(field, value);
                }
            }
        }
        //The floorEntry(K key) method is used to return a key-value mapping associated with the greatest key less than or equal to the given key, or null if there is no such key.
        public String get(String profileId, int version) {
            if (!profiles.containsKey(profileId))
                return null;
            else {
                Profile profile = profiles.get(profileId);
                Map<String, String> fields = profile.versionToMap.get(version);
                StringBuilder sb = new StringBuilder();
                sb.append("{\"" + profileId + "\": ");
                for (String field : fields.keySet()) {
                    sb.append("\"" + field + "\": " + "\"" + fields.get(field) + "\",");
                }
                sb.append("}");
                return sb.toString();
            }
        }

        public String getField(String profileId, int version, String field) {
            if (!profileId.contains(profileId))
                return null;
            else {
                Profile profile = profiles.get(profileId);
                if (!profile.versionToMap.containsKey(version))
                    return null;
                else {
                    Map<String, String> fields = profile.versionToMap.get(version);
                    if (fields.containsKey(field)) {
                        return fields.get(field);
                    } else {
                        return null;
                    }
                }
            }
        }

    public static void main(String[] args) {
       ProfileSystem resume = new ProfileSystem();
       resume.update("ABC","skills","java");
       resume.update("ABC","skills","python");
       resume.update("ABC", "education", "USC");

       System.out.println(resume.get("ABC",2));
    }
    }


