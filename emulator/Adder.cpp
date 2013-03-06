#include "Adder.h"

void Adder_t::init ( bool rand_init ) {
}
void Adder_t::clock_lo ( dat_t<1> reset ) {
  { Adder__io_out.values[0] = 0x7L; }
}
void Adder_t::clock_hi ( dat_t<1> reset ) {
}
void Adder_t::print ( FILE* f ) {
  fprintf(f, "%s", TO_CSTR(Adder__io_out));
  fprintf(f, "\n");
  fflush(f);
}
bool Adder_t::scan ( FILE* f ) {
  str_to_dat(read_tok(f), io_in0);
  str_to_dat(read_tok(f), io_in1);
  return(!feof(f));
}
void Adder_t::dump(FILE *f, int t) {
}
