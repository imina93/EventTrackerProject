export class Pokemon {

  id: number;
  name: string;
  nature: string;
  // ability: string;
  // ivSpread: string;
  // notes: string;


	// @Column(name="iv_spread")
	// private String ivSpread;
	// private String notes;

	// @ManyToOne()
	// @JoinColumn(name = "trainer_id")
	// private Trainer trainer;

  constructor(id: number=0, name: string='', nature: string='') {
    this.id = id;
    this.name = name;
    this.nature = nature;
  }
}
