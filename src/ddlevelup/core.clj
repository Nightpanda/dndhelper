(ns ddlevelup.core)

(def levelRequirements 
    {
        :1 0
        :2 300
        :3 900
        :4 2700
        :5 6500
        :6 14000
        :7 23000
        :8 34000
        :9 48000
        :10 64000
        :11 85000
        :12 100000
        :13 120000
        :14 140000
        :15 165000
        :16 195000
        :17 225000
        :18 265000
        :19 305000
        :20 355000
    })

(defn experienceNeededForLevelWithPartySize [level partySize]
    (* partySize (level levelRequirements)))

(defn currentLevel [xp]
    (key (last (sort-by last (filter #(>= xp (second %)) levelRequirements)))))

(defn nextLevel [level]
    (keyword (str (+ 1 (read-string (name level))))))

(defn experienceLeftUntilLevelWithPartySize [currentXp targetLevel partySize]
    (let [targetXp (experienceNeededForLevelWithPartySize targetLevel partySize)]
    (- targetXp currentXp)))
