(ns ddlevelup.core-test
  (:require [ddlevelup.core :refer :all]
            [clojure.test :refer :all]))

(deftest experienceNeededForLevelWithPartySize-test
  (testing "experienceNeededForLevelWithPartySize returns correct experience needed for different party sizes"
    (are [x y] (= x y)
     600 (experienceNeededForLevelWithPartySize :2 2)
     1200 (experienceNeededForLevelWithPartySize :2 4)
     115000 (experienceNeededForLevelWithPartySize :7 5)))

  (testing "experienceNeededForLevelWithPartySize returns correct experience needed for party of one"
    (are [x y] (= x y)
      300 (experienceNeededForLevelWithPartySize :2 1)
      900 (experienceNeededForLevelWithPartySize :3 1)
      2700 (experienceNeededForLevelWithPartySize :4 1)
      6500 (experienceNeededForLevelWithPartySize :5 1)
      14000 (experienceNeededForLevelWithPartySize :6 1)
      23000 (experienceNeededForLevelWithPartySize :7 1)
      34000 (experienceNeededForLevelWithPartySize :8 1)
      48000 (experienceNeededForLevelWithPartySize :9 1)
      64000 (experienceNeededForLevelWithPartySize :10 1)
      85000 (experienceNeededForLevelWithPartySize :11 1)
      100000 (experienceNeededForLevelWithPartySize :12 1)
      120000 (experienceNeededForLevelWithPartySize :13 1)
      140000 (experienceNeededForLevelWithPartySize :14 1)
      165000 (experienceNeededForLevelWithPartySize :15 1)
      195000 (experienceNeededForLevelWithPartySize :16 1)
      225000 (experienceNeededForLevelWithPartySize :17 1)
      265000 (experienceNeededForLevelWithPartySize :18 1)
      305000 (experienceNeededForLevelWithPartySize :19 1)
      355000 (experienceNeededForLevelWithPartySize :20 1))))

(deftest experienceLeftUntilLevelWithPartySize-test
  (testing "experienceLeftUntilLevelWithPartySize returns 300 
    for current experience of 0 with party size 1 to level 2"
      (is (= (experienceLeftUntilLevelWithPartySize 0 :2 1) 300)))
  (testing "experienceLeftUntilLevelWithPartySize returns 600
    for current experience of 0 with party size 2 to level 2"
      (is (= (experienceLeftUntilLevelWithPartySize 0 :2 2) 600)))
  (testing "experienceLeftUntilLevelWithPartySize returns 31000
    for current experience of 300 with party size 2 to level 8"
      (is (= (experienceLeftUntilLevelWithPartySize 3000 :8 2) 65000))))

(deftest currentLevel-test
  (testing "currentLevel returns correct level for given xp"
    (are [x y] (= x y)
    :1 (currentLevel 0)
    :1 (currentLevel 5)
    :2 (currentLevel 300)
    :2 (currentLevel 301)
    :20 (currentLevel 355000)
    :20 (currentLevel 356000))))

(deftest nextLevel-test
  (testing "nextLevel returns correct level for given level"
    (are [x y] (= x y)
    :2 (nextLevel :1)
    :3 (nextLevel :2))))
