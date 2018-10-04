package com.example.rapisodo.livedataviewmodel.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class Card extends BaseObservable {

    private String name;
    private String cmc;
    private String type;
    private String text;
    private String power;
    private String toughness;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getCmc() {
        return cmc;
    }

    public void setCmc(String cmc) {
        this.cmc = cmc;
    }

    @Bindable
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Bindable
    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Bindable
    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    //    "cards":[
//    {
//        "name":"Archangel Avacyn",
//            "names":[
//        "Archangel Avacyn",
//                "Avacyn, the Purifier"
//      ],
//        "manaCost":"{3}{W}{W}",
//            "cmc":5,
//            "colors":[
//        "White"
//      ],
//        "colorIdentity":[
//        "W"
//      ],
//        "type":"Legendary Creature — Angel",
//            "supertypes":[
//        "Legendary"
//      ],
//        "types":[
//        "Creature"
//      ],
//        "subtypes":[
//        "Angel"
//      ],
//        "rarity":"Mythic Rare",
//            "set":"SOI",
//            "text":"Flash\nFlying, vigilance\nWhen Archangel Avacyn enters the battlefield, creatures you control gain indestructible until end of turn.\nWhen a non-Angel creature you control dies, transform Archangel Avacyn at the beginning of the next upkeep.",
//            "artist":"James Ryman",
//            "number":"5a",
//            "power":"4",
//            "toughness":"4",
//            "layout":"double-faced",
//            "multiverseid":409741,
//            "imageUrl":"http://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=409741&type=card",
//            "rulings":[
//        {
//            "date":"2016-04-08",
//                "text":"Archangel Avacyn’s delayed triggered ability triggers at the beginning of the next upkeep regardless of whose turn it is."
//        },
//        {
//            "date":"2016-04-08",
//                "text":"Archangel Avacyn’s delayed triggered ability won’t cause it to transform back into Archangel Avacyn if it has already transformed into Avacyn, the Purifier, perhaps because several creatures died in one turn."
//        },
//        {
//            "date":"2016-04-08",
//                "text":"For more information on double-faced cards, see the Shadows over Innistrad mechanics article (http://magic.wizards.com/en/articles/archive/feature/shadows-over-innistrad-mechanics)."
//        }
//      ],
//        "foreignNames":[
//        {
//            "name":"大天使艾维欣",
//                "language":"Chinese Simplified",
//                "multiverseid":410071
//        },
//        {
//            "name":"大天使艾維欣",
//                "language":"Chinese Traditional",
//                "multiverseid":410401
//        },
//        {
//            "name":"Archange Avacyn",
//                "language":"French",
//                "multiverseid":411061
//        },
//        {
//            "name":"Erzengel Avacyn",
//                "language":"German",
//                "multiverseid":410731
//        },
//        {
//            "name":"Arcangelo Avacyn",
//                "language":"Italian",
//                "multiverseid":411391
//        },
//        {
//            "name":"大天使アヴァシン",
//                "language":"Japanese",
//                "multiverseid":411721
//        },
//        {
//            "name":"대천사 아바신",
//                "language":"Korean",
//                "multiverseid":412051
//        },
//        {
//            "name":"Arcanjo Avacyn",
//                "language":"Portuguese (Brazil)",
//                "multiverseid":412381
//        },
//        {
//            "name":"Архангел Авацина",
//                "language":"Russian",
//                "multiverseid":412711
//        },
//        {
//            "name":"Arcángel Avacyn",
//                "language":"Spanish",
//                "multiverseid":413041
//        }
//      ],
//        "printings":[
//        "SOI"
//      ],
//        "originalText":"Flash\nFlying, vigilance\nWhen Archangel Avacyn enters the battlefield, creatures you control gain indestructible until end of turn.\nWhen a non-Angel creature you control dies, transform Archangel Avacyn at the beginning of the next upkeep.",
//            "originalType":"Legendary Creature — Angel",
//            "id":"02ea5ddc89d7847abc77a0fbcbf2bc74e6456559"
//    },
//    { ... },
//    { ... }
//  ]
//}
}
